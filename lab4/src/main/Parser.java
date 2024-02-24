package main;

import Generated.Labtwo.Classes.*;
import Generated.Labtwo.Engine;
import Syntaxer.ASTNode;

import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;

public class Parser {
    public static void main(String[] args) throws IOException, ParseException {
        Engine engine;
        try {
            engine = new Engine();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ASTNode res = engine.parse(Files.readString(Path.of("D:\\mt\\lab4\\src\\main\\in.txt")));
        Graphviz.fromGraph(res.toGraph()).width(1024).render(Format.PNG).
                toFile(new File("example.png"));
    }
}
