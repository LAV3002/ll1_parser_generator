package Reflection;

import Rules.Rule;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class EngineBuilder extends Builder {

    static String build(List<Rule> rules, String parserName) {
        String firstPart = """
                import Lexer.Lexer;
                import Rules.FFCalculator;
                import Rules.Rule;
                import Rules.StartRule;
                import Symbol.*;
                import Syntaxer.ASTNode;
                import Syntaxer.ParseTable;
                                
                import java.io.*;
                import java.text.ParseException;
                import java.util.List;
                import java.util.Stack;

                public class Engine {
                    private final ParseTable parseTable;
                    private final NonterminalSymbol start;

                    final String epsTerm;
                    final String endTerm;

                    public Engine() throws IOException, ClassNotFoundException {
                            FileInputStream fileInputStream = new FileInputStream("src/Generated/%s/calculator.ser");
                            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                            FFCalculator calculator = (FFCalculator) objectInputStream.readObject();
                    
                            parseTable = new ParseTable(calculator.getRules(), calculator);
                            start = calculator.getStart();
                            epsTerm = calculator.getEpsTerm();
                            endTerm = calculator.getEndTerm();
                    }

                    public ASTNode parse(String in) throws ParseException, IOException {
                        Lexer lexer = new Lexer(parseTable.getTerminals().stream().map(TerminalSymbol::getValue).toList(), new ByteArrayInputStream(in.getBytes()));
                        List<String> tokens = lexer.getTokens();
                        int tokensPointer = 0;
                        Stack<ASTNode> stack = new Stack<>();
                        """;

        String secondPart = """
                        ASTNode start = new ASTNode(res, new StartRule(), this.start, 0);
                        stack.push(start);
                        while (!stack.isEmpty()) {
                            ASTNode cur = stack.pop();
                            String curToken;
                            if (tokens.size() > tokensPointer) {
                                curToken = tokens.get(tokensPointer);
                            } else {
                                curToken = endTerm;
                            }
                            if (cur.getNode().getType() == SymbolType.TERMINAL) {
                                if (cur.getNode().getValue().equals(epsTerm)) {
                                    continue;
                                }
                                if (cur.getNode().getValue().equals(curToken)) {
                                    tokensPointer++;
                                } else {
                                    throw new ParseException("Bad token: " + curToken, tokensPointer);
                                }
                            }
                            if (cur.getNode().getType() == SymbolType.NONTERMINAL) {
                                cur.getRule().execute(cur.inRulePos);
                                Rule newRule = parseTable.getRule((NonterminalSymbol) cur.getNode(), new TerminalSymbol(curToken));
                                List<Symbol> symbols = newRule.getRight();
                """;

        String thirdPart = """
                            }
                            if (cur.getNode().getType() == SymbolType.BROADCASTING) {
                                cur.getRule().execute(cur.inRulePos);
                            }
                        }
                        return start;
                    }
                }
                """;

        StringBuilder out = new StringBuilder();
        out.append("package Generated.").append(parserName).append(";\n");
        newLine(out);
        out.append("import Generated.").append(parserName).append(".Classes.*;\n");
        out.append("import Generated.").append(parserName).append(".Rules.*;\n");
        newLine(out);
        out.append(firstPart.formatted(parserName));
        tab(out, 2);
        out.append(rules.get(0).getLeft().getValue()).append(" res = new ").append(rules.get(0).getLeft().getValue()).
                append("();\n");
        out.append(secondPart);
        createSwitch(out, rules);
        out.append(thirdPart);
        return out.toString();
    }

    private static void createSwitch(StringBuilder out, List<Rule> rules) {
        tab(out, 4);
        out.append("switch (newRule.getNumber()) {\n");
        for (int ruleNumber = 0; ruleNumber < rules.size(); ruleNumber++) {
            tab(out, 5);
            out.append("case ").append(ruleNumber).append(":\n");
            Rule currentRule = rules.get(ruleNumber);
            tab(out, 6);
            out.append("Rule_").append(ruleNumber).append(" ").
                    append("rule_").append(ruleNumber).append(" = new Rule_").append(ruleNumber).
                    append("((").append(currentRule.getLeft().getValue()).append(") cur.getHolder());\n");
            List<String> nodes = new ArrayList<>();
            for (int symbNumber = currentRule.getRight().size(); symbNumber > 0; symbNumber--) {
                String nodeName = "node_" + ruleNumber + "_" + symbNumber;
                tab(out, 6);
                out.append("ASTNode ").append(nodeName).append(" = ").append("new ASTNode(rule_").append(ruleNumber).
                        append(".$").append(symbNumber).append(", rule_").append(ruleNumber).append(", symbols.get(").
                        append(symbNumber - 1).append("), ").append(symbNumber).append(");\n");
                nodes.add(nodeName);
                tab(out, 6);
                out.append("stack.push(").append(nodeName).append(");\n");
            }
            for (int nodeNumber = nodes.size() - 1; nodeNumber >= 0; nodeNumber--) {
                tab(out, 6);
                out.append("cur.addChild(").append(nodes.get(nodeNumber)).append(");\n");
            }
            tab(out, 6);
            out.append("break;\n");
        }
        tab(out, 4);
        out.append("}\n");
    }

    public static void generate(List<Rule> rules, Path directory, String parserName) throws IOException {
//        if (Files.notExists(directory.resolve(declaration.getName()))) {
//            Files.createFile(directory.resolve(declaration.getName()));
//        }
        try (BufferedWriter writer = Files.newBufferedWriter(directory.resolve("Engine.java"))) {
            writer.write(build(rules, parserName));
        }
    }
}
