package main;

import RulesParser.RulesLexer;
import RulesParser.RulesParser;
import RulesParser.RulesWalker;
import Reflection.ClassBuilder;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.nio.file.Path;

public class Main {

    public void inc(StringBuilder sb) {
        sb.append("c");
    }
    public static void main(String[] args) throws Exception
    {
        RulesLexer lexer = new RulesLexer(CharStreams.fromFileName("D:\\mt\\lab4\\src\\main\\grammar.txt"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RulesParser parser = new RulesParser(tokens);
        ParseTree tree = parser.start();
        ParseTreeWalker walker = new ParseTreeWalker();
        RulesWalker listener = new RulesWalker();
        walker.walk(listener, tree);
//        ClassBuilder.generate(listener.getDeclarations(), Path.of("D:\\mt\\lab4\\src\\Classes"));
    }
}
