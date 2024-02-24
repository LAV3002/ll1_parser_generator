package Reflection;

import Rules.Rule;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public abstract class Builder {
    static String tab = "    ";

    protected static void newLine(StringBuilder out) {
        out.append("\n");
    }

    protected static void tab(StringBuilder out, int count) {
        out.append(tab.repeat(count));
    }
}
