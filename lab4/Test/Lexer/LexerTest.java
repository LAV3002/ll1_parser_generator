package Lexer;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LexerTest {

    private final List<String> tokens = List.of("not", "(", "v", "and", ")", " ");

    @Test
    public void simpleTest() {
        String testString = "not (v and v)";
        Lexer lexer = new Lexer(tokens, new ByteArrayInputStream(testString.getBytes()));
        try {
            List<String> result = lexer.getTokens();
            assertEquals(List.of("not", " ", "(", "v", " ", "and", " ", "v", ")"), result);
        } catch (ParseException e) {
            Assert.fail("ParseException have been thrown");
        } catch (IOException e) {
            Assert.fail("IOException have been thrown");
        }
    }

//    @Test
//    public void xOrTest() {
//        String testString = "x or b";
//        LexicalAnalyzer la = new LexicalAnalyzer(new ByteArrayInputStream(testString.getBytes()));
//        try {
//            assertEquals(Token.LETTER, la.nextToken());
//            assertEquals(Token.OR, la.nextToken());
//            assertEquals(Token.LETTER, la.nextToken());
//            assertEquals(Token.END, la.nextToken());
//        } catch (ParseException e) {
//            Assert.fail("Exception have been thrown");
//        }
//    }
//
//    @Test
//    public void xorTest() {
//        String testString = "x xor b";
//        LexicalAnalyzer la = new LexicalAnalyzer(new ByteArrayInputStream(testString.getBytes()));
//        try {
//            assertEquals(Token.LETTER, la.nextToken());
//            assertEquals(Token.XOR, la.nextToken());
//            assertEquals(Token.LETTER, la.nextToken());
//            assertEquals(Token.END, la.nextToken());
//        } catch (ParseException e) {
//            Assert.fail("Exception have been thrown");
//        }
//    }
//
//    @Test
//    public void mediumTest() {
//        List<Token> tokensToTest = List.of(Token.NOT, Token.LPAREN, Token.LETTER, Token.XOR,
//                Token.LETTER, Token.RPAREN, Token.OR, Token.LETTER, Token.AND, Token.LETTER,
//                Token.AND, Token.LETTER, Token.NOTIN, Token.LETTER, Token.AND, Token.LETTER,
//                Token.IN, Token.LETTER, Token.END);
//        String testString = "not (a xor b) or b and c and v not in p and v in t";
//        LexicalAnalyzer la = new LexicalAnalyzer(new ByteArrayInputStream(testString.getBytes()));
//        try {
//            for (Token token : tokensToTest) {
//                assertEquals(token, la.nextToken());
//            }
//        } catch (ParseException e) {
//            Assert.fail("Exception have been thrown");
//        }
//    }
}