package Reflection;

import RulesParser.NonterminalDeclaration;
import RulesParser.VarDeclaration;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ClassBuilder extends Builder {
    static String build(NonterminalDeclaration declaration, String parserName) {
        StringBuilder out = new StringBuilder();
        out.append("package Generated.").append(parserName).append(".Classes;\n");
        out.append("""

                public class\s""");
        out.append(declaration.getName());
        out.append(" {\n");
        for (VarDeclaration varDeclaration : declaration.getInh()) {
            tab(out, 1);
            out.append("public ").append(varDeclaration.getType()).append(" ").append(varDeclaration.getName()).append("; \n");
        }
        for (VarDeclaration varDeclaration : declaration.getSynt()) {
            tab(out, 1);
            out.append("public ").append(varDeclaration.getType()).append(" ").append(varDeclaration.getName()).append("; \n");
        }
        out.append("}\n");
        return out.toString();
    }

    public static void generate(NonterminalDeclaration declaration, Path directory, String parserName) throws IOException {
//        if (Files.notExists(directory.resolve(declaration.getName()))) {
//            Files.createFile(directory.resolve(declaration.getName()));
//        }
        try (BufferedWriter writer = Files.newBufferedWriter(directory.resolve(declaration.getName() + ".java"))) {
            writer.write(build(declaration, parserName));
        }
    }

    public static void generate(List<NonterminalDeclaration> declarations, Path directory, String parserName) throws IOException {
        for (NonterminalDeclaration decl : declarations) {
            generate(decl, directory, parserName);
        }
        generate(new NonterminalDeclaration("NT", new ArrayList<>(), new ArrayList<>()), directory, parserName);
        generate(new NonterminalDeclaration("BS", new ArrayList<>(), new ArrayList<>()), directory, parserName);
    }
}
