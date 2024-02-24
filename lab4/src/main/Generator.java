package main;

import Reflection.ClassBuilder;
import Reflection.EngineBuilder;
import Reflection.RuleBuilder;
import Rules.FFCalculator;
import Rules.Rule;
import RulesParser.*;
import Symbol.NonterminalSymbol;
import Symbol.TerminalSymbol;
import Syntaxer.ParseTable;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Generator {
    public static void main(String[] args) throws IOException {
        Path destination = Path.of("src/Generated").resolve(args[0]);
        Path source = Path.of(args[1]);

        RulesLexer lexer = new RulesLexer(CharStreams.fromFileName(source.toString()));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RulesParser parser = new RulesParser(tokens);
        ErrorListener errorListener = new ErrorListener();
        parser.addErrorListener(errorListener);
        ParseTree tree = parser.start();
        if (!errorListener.errors.isEmpty()) {
            System.out.println("Bad grammar:");
            for (String err : errorListener.errors) {
                System.out.println(err);
            }
            return;
        }
        ParseTreeWalker walker = new ParseTreeWalker();
        RulesWalker listener = new RulesWalker();
        walker.walk(listener, tree);
        System.out.println("Rules:");
        for(Rule rule : listener.getRules()) {
            System.out.println(rule);
        }

        FFCalculator calculator = new FFCalculator(listener.getRules());
        System.out.println("Table:");
        System.out.println(new ParseTable(calculator.getRules(), calculator));

        for (NonterminalSymbol nonterminalSymbol : calculator.getNonterminals()) {
            System.out.print(nonterminalSymbol.getValue() + " First: ");
            for (TerminalSymbol terminalSymbol : calculator.getFirst().get(nonterminalSymbol)) {
                System.out.print(terminalSymbol + " ");
            }
            System.out.print(" | Follow: ");
            for (TerminalSymbol terminalSymbol : calculator.getFollow().get(nonterminalSymbol)) {
                System.out.print(terminalSymbol + " ");
            }
            System.out.println();
        }

        System.out.print("Checking ll1: ");
        if (calculator.checkLL1()) {
            System.out.println("ok!");
        } else {
            System.out.println("bad...");
            return;
        }

        Files.createDirectories(destination);
        Path classes = destination.resolve("Classes");
        Path rules = destination.resolve("Rules");
        Files.createDirectories(classes);
        Files.createDirectories(rules);

        ClassBuilder.generate(listener.getDeclarations(), classes, args[0]);

        Map<String, List<VarDeclaration>> declarations = new TreeMap<>();
        for (NonterminalDeclaration declaration : listener.getDeclarations()) {
            declarations.put(declaration.getName(), declaration.getInh());
        }

        RuleBuilder.generate(listener.getRules(), rules, args[0], declarations);
        EngineBuilder.generate(listener.getRules(), destination, args[0]);

        FileOutputStream outputStream = new FileOutputStream(destination.resolve("calculator.ser").toString());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(calculator);
    }

    public static class ErrorListener extends BaseErrorListener {
        List<String> errors = new ArrayList<>();
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
                                String msg, RecognitionException e) {
            errors.add("line " + line + ":" + charPositionInLine + " " + msg);
        }
    }
}
