package Lexer;

import java.util.Map;
import java.util.TreeMap;

public class Trie {
    private final Node start = new Node();

    public void addWord(String word) {
        Node curNode = start;
        for (int i = 0; i < word.length(); i++) {
            curNode = curNode.addSuffix(word.charAt(i));
        }
        curNode.setFinish();
    }

    public Node getStart() {
        return start;
    }

    public Node makeStep(Node from, Character chr) {
        return from.makeStep(chr);
    }

    public boolean isFinish(Node toTest) {
        return toTest.isFinish();
    }

    public static class Node {
        private boolean finish = false;
        private final Map<Character, Node> suffixes = new TreeMap<>();

        public Node addSuffix(Character chr) {
            if (suffixes.containsKey(chr)) {
                return suffixes.get(chr);
            }
            suffixes.put(chr, new Node());
            return suffixes.get(chr);
        }

        public void setFinish() {
            finish = true;
        }

        public boolean isFinish() {
            return finish;
        }

        public Node makeStep(Character chr) {
            return suffixes.get(chr);
        }
    }
}
