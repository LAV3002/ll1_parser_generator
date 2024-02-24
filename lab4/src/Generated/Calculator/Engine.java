package Generated.Calculator;

import Generated.Calculator.Classes.*;
import Generated.Calculator.Rules.*;

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
            FileInputStream fileInputStream = new FileInputStream("src/Generated/Calculator/calculator.ser");
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
        E res = new E();
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
                switch (newRule.getNumber()) {
                    case 0:
                        Rule_0 rule_0 = new Rule_0((E) cur.getHolder());
                        ASTNode node_0_3 = new ASTNode(rule_0.$3, rule_0, symbols.get(2), 3);
                        stack.push(node_0_3);
                        ASTNode node_0_2 = new ASTNode(rule_0.$2, rule_0, symbols.get(1), 2);
                        stack.push(node_0_2);
                        ASTNode node_0_1 = new ASTNode(rule_0.$1, rule_0, symbols.get(0), 1);
                        stack.push(node_0_1);
                        cur.addChild(node_0_1);
                        cur.addChild(node_0_2);
                        cur.addChild(node_0_3);
                        break;
                    case 1:
                        Rule_1 rule_1 = new Rule_1((Ep) cur.getHolder());
                        ASTNode node_1_5 = new ASTNode(rule_1.$5, rule_1, symbols.get(4), 5);
                        stack.push(node_1_5);
                        ASTNode node_1_4 = new ASTNode(rule_1.$4, rule_1, symbols.get(3), 4);
                        stack.push(node_1_4);
                        ASTNode node_1_3 = new ASTNode(rule_1.$3, rule_1, symbols.get(2), 3);
                        stack.push(node_1_3);
                        ASTNode node_1_2 = new ASTNode(rule_1.$2, rule_1, symbols.get(1), 2);
                        stack.push(node_1_2);
                        ASTNode node_1_1 = new ASTNode(rule_1.$1, rule_1, symbols.get(0), 1);
                        stack.push(node_1_1);
                        cur.addChild(node_1_1);
                        cur.addChild(node_1_2);
                        cur.addChild(node_1_3);
                        cur.addChild(node_1_4);
                        cur.addChild(node_1_5);
                        break;
                    case 2:
                        Rule_2 rule_2 = new Rule_2((Ep) cur.getHolder());
                        ASTNode node_2_2 = new ASTNode(rule_2.$2, rule_2, symbols.get(1), 2);
                        stack.push(node_2_2);
                        ASTNode node_2_1 = new ASTNode(rule_2.$1, rule_2, symbols.get(0), 1);
                        stack.push(node_2_1);
                        cur.addChild(node_2_1);
                        cur.addChild(node_2_2);
                        break;
                    case 3:
                        Rule_3 rule_3 = new Rule_3((T) cur.getHolder());
                        ASTNode node_3_3 = new ASTNode(rule_3.$3, rule_3, symbols.get(2), 3);
                        stack.push(node_3_3);
                        ASTNode node_3_2 = new ASTNode(rule_3.$2, rule_3, symbols.get(1), 2);
                        stack.push(node_3_2);
                        ASTNode node_3_1 = new ASTNode(rule_3.$1, rule_3, symbols.get(0), 1);
                        stack.push(node_3_1);
                        cur.addChild(node_3_1);
                        cur.addChild(node_3_2);
                        cur.addChild(node_3_3);
                        break;
                    case 4:
                        Rule_4 rule_4 = new Rule_4((Tp) cur.getHolder());
                        ASTNode node_4_5 = new ASTNode(rule_4.$5, rule_4, symbols.get(4), 5);
                        stack.push(node_4_5);
                        ASTNode node_4_4 = new ASTNode(rule_4.$4, rule_4, symbols.get(3), 4);
                        stack.push(node_4_4);
                        ASTNode node_4_3 = new ASTNode(rule_4.$3, rule_4, symbols.get(2), 3);
                        stack.push(node_4_3);
                        ASTNode node_4_2 = new ASTNode(rule_4.$2, rule_4, symbols.get(1), 2);
                        stack.push(node_4_2);
                        ASTNode node_4_1 = new ASTNode(rule_4.$1, rule_4, symbols.get(0), 1);
                        stack.push(node_4_1);
                        cur.addChild(node_4_1);
                        cur.addChild(node_4_2);
                        cur.addChild(node_4_3);
                        cur.addChild(node_4_4);
                        cur.addChild(node_4_5);
                        break;
                    case 5:
                        Rule_5 rule_5 = new Rule_5((Tp) cur.getHolder());
                        ASTNode node_5_2 = new ASTNode(rule_5.$2, rule_5, symbols.get(1), 2);
                        stack.push(node_5_2);
                        ASTNode node_5_1 = new ASTNode(rule_5.$1, rule_5, symbols.get(0), 1);
                        stack.push(node_5_1);
                        cur.addChild(node_5_1);
                        cur.addChild(node_5_2);
                        break;
                    case 6:
                        Rule_6 rule_6 = new Rule_6((F) cur.getHolder());
                        ASTNode node_6_2 = new ASTNode(rule_6.$2, rule_6, symbols.get(1), 2);
                        stack.push(node_6_2);
                        ASTNode node_6_1 = new ASTNode(rule_6.$1, rule_6, symbols.get(0), 1);
                        stack.push(node_6_1);
                        cur.addChild(node_6_1);
                        cur.addChild(node_6_2);
                        break;
                    case 7:
                        Rule_7 rule_7 = new Rule_7((F) cur.getHolder());
                        ASTNode node_7_4 = new ASTNode(rule_7.$4, rule_7, symbols.get(3), 4);
                        stack.push(node_7_4);
                        ASTNode node_7_3 = new ASTNode(rule_7.$3, rule_7, symbols.get(2), 3);
                        stack.push(node_7_3);
                        ASTNode node_7_2 = new ASTNode(rule_7.$2, rule_7, symbols.get(1), 2);
                        stack.push(node_7_2);
                        ASTNode node_7_1 = new ASTNode(rule_7.$1, rule_7, symbols.get(0), 1);
                        stack.push(node_7_1);
                        cur.addChild(node_7_1);
                        cur.addChild(node_7_2);
                        cur.addChild(node_7_3);
                        cur.addChild(node_7_4);
                        break;
                    case 8:
                        Rule_8 rule_8 = new Rule_8((NUMBER) cur.getHolder());
                        ASTNode node_8_3 = new ASTNode(rule_8.$3, rule_8, symbols.get(2), 3);
                        stack.push(node_8_3);
                        ASTNode node_8_2 = new ASTNode(rule_8.$2, rule_8, symbols.get(1), 2);
                        stack.push(node_8_2);
                        ASTNode node_8_1 = new ASTNode(rule_8.$1, rule_8, symbols.get(0), 1);
                        stack.push(node_8_1);
                        cur.addChild(node_8_1);
                        cur.addChild(node_8_2);
                        cur.addChild(node_8_3);
                        break;
                    case 9:
                        Rule_9 rule_9 = new Rule_9((NUMBER) cur.getHolder());
                        ASTNode node_9_2 = new ASTNode(rule_9.$2, rule_9, symbols.get(1), 2);
                        stack.push(node_9_2);
                        ASTNode node_9_1 = new ASTNode(rule_9.$1, rule_9, symbols.get(0), 1);
                        stack.push(node_9_1);
                        cur.addChild(node_9_1);
                        cur.addChild(node_9_2);
                        break;
                    case 10:
                        Rule_10 rule_10 = new Rule_10((DIGIT) cur.getHolder());
                        ASTNode node_10_2 = new ASTNode(rule_10.$2, rule_10, symbols.get(1), 2);
                        stack.push(node_10_2);
                        ASTNode node_10_1 = new ASTNode(rule_10.$1, rule_10, symbols.get(0), 1);
                        stack.push(node_10_1);
                        cur.addChild(node_10_1);
                        cur.addChild(node_10_2);
                        break;
                    case 11:
                        Rule_11 rule_11 = new Rule_11((DIGIT) cur.getHolder());
                        ASTNode node_11_2 = new ASTNode(rule_11.$2, rule_11, symbols.get(1), 2);
                        stack.push(node_11_2);
                        ASTNode node_11_1 = new ASTNode(rule_11.$1, rule_11, symbols.get(0), 1);
                        stack.push(node_11_1);
                        cur.addChild(node_11_1);
                        cur.addChild(node_11_2);
                        break;
                    case 12:
                        Rule_12 rule_12 = new Rule_12((DIGIT) cur.getHolder());
                        ASTNode node_12_2 = new ASTNode(rule_12.$2, rule_12, symbols.get(1), 2);
                        stack.push(node_12_2);
                        ASTNode node_12_1 = new ASTNode(rule_12.$1, rule_12, symbols.get(0), 1);
                        stack.push(node_12_1);
                        cur.addChild(node_12_1);
                        cur.addChild(node_12_2);
                        break;
                    case 13:
                        Rule_13 rule_13 = new Rule_13((DIGIT) cur.getHolder());
                        ASTNode node_13_2 = new ASTNode(rule_13.$2, rule_13, symbols.get(1), 2);
                        stack.push(node_13_2);
                        ASTNode node_13_1 = new ASTNode(rule_13.$1, rule_13, symbols.get(0), 1);
                        stack.push(node_13_1);
                        cur.addChild(node_13_1);
                        cur.addChild(node_13_2);
                        break;
                    case 14:
                        Rule_14 rule_14 = new Rule_14((DIGIT) cur.getHolder());
                        ASTNode node_14_2 = new ASTNode(rule_14.$2, rule_14, symbols.get(1), 2);
                        stack.push(node_14_2);
                        ASTNode node_14_1 = new ASTNode(rule_14.$1, rule_14, symbols.get(0), 1);
                        stack.push(node_14_1);
                        cur.addChild(node_14_1);
                        cur.addChild(node_14_2);
                        break;
                    case 15:
                        Rule_15 rule_15 = new Rule_15((DIGIT) cur.getHolder());
                        ASTNode node_15_2 = new ASTNode(rule_15.$2, rule_15, symbols.get(1), 2);
                        stack.push(node_15_2);
                        ASTNode node_15_1 = new ASTNode(rule_15.$1, rule_15, symbols.get(0), 1);
                        stack.push(node_15_1);
                        cur.addChild(node_15_1);
                        cur.addChild(node_15_2);
                        break;
                    case 16:
                        Rule_16 rule_16 = new Rule_16((DIGIT) cur.getHolder());
                        ASTNode node_16_2 = new ASTNode(rule_16.$2, rule_16, symbols.get(1), 2);
                        stack.push(node_16_2);
                        ASTNode node_16_1 = new ASTNode(rule_16.$1, rule_16, symbols.get(0), 1);
                        stack.push(node_16_1);
                        cur.addChild(node_16_1);
                        cur.addChild(node_16_2);
                        break;
                    case 17:
                        Rule_17 rule_17 = new Rule_17((DIGIT) cur.getHolder());
                        ASTNode node_17_2 = new ASTNode(rule_17.$2, rule_17, symbols.get(1), 2);
                        stack.push(node_17_2);
                        ASTNode node_17_1 = new ASTNode(rule_17.$1, rule_17, symbols.get(0), 1);
                        stack.push(node_17_1);
                        cur.addChild(node_17_1);
                        cur.addChild(node_17_2);
                        break;
                    case 18:
                        Rule_18 rule_18 = new Rule_18((DIGIT) cur.getHolder());
                        ASTNode node_18_2 = new ASTNode(rule_18.$2, rule_18, symbols.get(1), 2);
                        stack.push(node_18_2);
                        ASTNode node_18_1 = new ASTNode(rule_18.$1, rule_18, symbols.get(0), 1);
                        stack.push(node_18_1);
                        cur.addChild(node_18_1);
                        cur.addChild(node_18_2);
                        break;
                    case 19:
                        Rule_19 rule_19 = new Rule_19((DIGIT) cur.getHolder());
                        ASTNode node_19_2 = new ASTNode(rule_19.$2, rule_19, symbols.get(1), 2);
                        stack.push(node_19_2);
                        ASTNode node_19_1 = new ASTNode(rule_19.$1, rule_19, symbols.get(0), 1);
                        stack.push(node_19_1);
                        cur.addChild(node_19_1);
                        cur.addChild(node_19_2);
                        break;
                }
            }
            if (cur.getNode().getType() == SymbolType.BROADCASTING) {
                cur.getRule().execute(cur.inRulePos);
            }
        }
        return start;
    }
}
