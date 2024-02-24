package Reflection;

import Rules.Rule;
import RulesParser.VarDeclaration;
import Symbol.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class RuleBuilder extends Builder {
    static String build(Rule rule, String parserName, Map<String, List<VarDeclaration>> declarations) {
        StringBuilder out = new StringBuilder();
        createHeader(out, rule, parserName);
        createFieldsDecl(out, rule);
        newLine(out);
        createConstructor(out, rule);
        newLine(out);
        createExecute(out, rule);
        newLine(out);
        createFunctions(out, rule, declarations);
        out.append("}\n");
        return out.toString();
    }

    private static void createHeader(StringBuilder out, Rule rule, String parserName) {
        out.append("package Generated.").append(parserName).append(".Rules;\n");
        newLine(out);
        out.append("import Generated.").append(parserName).append(".Classes.*;\n");
        newLine(out);
        out.append("""   
                import Rules.ERule;

                public class Rule_""").append(rule.getNumber()).append(" implements ERule {\n");
    }

    private static void createFieldsDecl(StringBuilder out, Rule rule) {
        tab(out, 1);
        out.append("public ").append(rule.getLeft().getValue()).append(" $0;\n");
        for (int i = 1; i <= rule.getRight().size(); i++) {
            tab(out, 1);
            Symbol cur = rule.getRight().get(i - 1);
            if (cur.getType() == SymbolType.TERMINAL) {
                out.append("public NT ").append(" $").append(i).append(";\n");
            }
            if (cur.getType() == SymbolType.NONTERMINAL) {
                out.append("public ").append(cur.getValue()).append(" $").append(i).append(";\n");
            }
            if (cur.getType() == SymbolType.BROADCASTING) {
                out.append("public BS ").append(" $").append(i).append(";\n");
            }
        }
    }

    private static void createConstructor(StringBuilder out, Rule rule) {
        tab(out, 1);
        out.append("public Rule_").append(rule.getNumber()).
                append("(").append(rule.getLeft().getValue()).append(" root) {\n");
        tab(out, 2);
        out.append("$0 = root;\n");
        for (int i = 1; i <= rule.getRight().size(); i++) {
            Symbol cur = rule.getRight().get(i - 1);
            tab(out, 2);
            out.append("$").append(i).append(" = new ");
            if (cur.getType() == SymbolType.TERMINAL) {
                out.append("NT");
            }
            if (cur.getType() == SymbolType.NONTERMINAL) {
                out.append(cur.getValue());
            }
            if (cur.getType() == SymbolType.BROADCASTING) {
                out.append("BS");
            }
            out.append("();\n");
        }
        tab(out, 1);
        out.append("}\n");
    }

    private static void createExecute(StringBuilder out, Rule rule) {
        out.append("""
                    @Override
                    public void execute(Integer pos) {
                        switch (pos) {
                """);
        for (int i = 1; i <= rule.getRight().size(); i++) {
            tab(out, 3);
            out.append("case ").append(i).append(":\n");
            tab(out, 4);
            out.append("f_").append(i).append("();\n");
            tab(out, 4);
            out.append("break;\n");
        }
        tab(out, 2);
        out.append("}\n");
        tab(out, 1);
        out.append("}\n");
    }

    private static void createFunctions(StringBuilder out, Rule rule, Map<String, List<VarDeclaration>> declarations) {
        for (int i = 1; i <= rule.getRight().size(); i++) {
            Symbol cur = rule.getRight().get(i - 1);
            tab(out, 1);
            if (cur.getType() == SymbolType.TERMINAL || cur.getType() == SymbolType.BROADCASTING) {
                out.append("private void f_").append(i).append("() {").append(cur.getCode()).append("}\n");;
            }
            if (cur.getType() == SymbolType.NONTERMINAL) {
                out.append("private void f_").append(i).append("() {\n");
                NonterminalSymbol ccur = (NonterminalSymbol) cur;
                List<VarDeclaration> curDeclarations = declarations.get(ccur.getValue());
                for (int j = 0; j < curDeclarations.size(); j++) {
                    out.append("$").append(i).append(".").append(curDeclarations.get(j).getName()).append(" = ").
                            append(ccur.getAssignments().get(j)).append(";\n");
                }
                tab(out, 1);
                out.append("}\n");
            }
            if (i != rule.getRight().size()) {
                newLine(out);
            }
        }
    }

    public static void generate(Rule rule, Path directory, String parserName,
                                Map<String, List<VarDeclaration>> declarations) throws IOException {
//        if (Files.notExists(directory.resolve(declaration.getName()))) {
//            Files.createFile(directory.resolve(declaration.getName()));
//        }
        try (BufferedWriter writer = Files.newBufferedWriter(directory.resolve("Rule_" + rule.getNumber() + ".java"))) {
            writer.write(build(rule, parserName, declarations));
        }
    }

    public static void generate(List<Rule> rules, Path directory, String parserName,
                                Map<String, List<VarDeclaration>> declarations) throws IOException {
        for (Rule rule : rules) {
            generate(rule, directory, parserName, declarations);
        }
    }
}
