package Lexer;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Lexer {
    Trie trie = new Trie();
    InputStream is;
    StringBuilder buffer = new StringBuilder();
    int curPos = 0;


    public Lexer(List<String> tokens, InputStream is) {
        this.is = is;
        for (String token : tokens) {
            trie.addWord(token);
        }
    }

    public List<String> getTokens() throws ParseException, IOException {
        List<String> toReturn = new ArrayList<>();
        skipWS();
        String toAdd = getBestMatch();
        while (toAdd != null) {
            toReturn.add(toAdd);
            skipWS();
            toAdd = getBestMatch();
        }
        return toReturn;
    }

    private String getBestMatch() throws ParseException, IOException {
        Trie.Node cur = trie.getStart();
        int i = 0;
        int lastSuc = -1;
        while (is.available() > 0 || buffer.length() > i) {
            if (buffer.length() <= i) {
                try {
                    buffer.append(Character.toChars(is.read()));
                    curPos++;
                } catch (IOException e) {
                    throw new ParseException(e.getMessage(), curPos);
                }
            }
            cur = trie.makeStep(cur, buffer.charAt(i));
            if (cur == null) {
                break;
            }
            if (cur.isFinish()) {
                lastSuc = i;
            }
            i++;
        }
        if (lastSuc == -1) {
            return null;
        }
        String toReturn = buffer.substring(0, i);
        buffer.delete(0, i);
        return toReturn;
    }

    private void skipWS() throws IOException, ParseException {
        int i = 0;
        int lastSuc = -1;
        while (is.available() > 0 || buffer.length() > 0) {
            if (buffer.length() <= i) {
                try {
                    buffer.append(Character.toChars(is.read()));
                    curPos++;
                } catch (IOException e) {
                    throw new ParseException(e.getMessage(), curPos);
                }
            }
            if (Character.isWhitespace(buffer.charAt(i))) {
                lastSuc = i;
            } else {
                break;
            }
            i++;
        }
        if (lastSuc == -1) {
            return;
        }
        buffer.delete(0, i);
    }
}
