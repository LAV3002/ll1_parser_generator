package Generated.Test;

import Generated.Test.Classes.*;
import Generated.Test.Rules.*;

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
            FileInputStream fileInputStream = new FileInputStream("src/Generated/Test/calculator.ser");
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
        A res = new A();
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
                        Rule_0 rule_0 = new Rule_0((A) cur.getHolder());
                        stack.push(new ASTNode(rule_0.$3, rule_0, symbols.get(2), 3));
                        stack.push(new ASTNode(rule_0.$2, rule_0, symbols.get(1), 2));
                        stack.push(new ASTNode(rule_0.$1, rule_0, symbols.get(0), 1));
                        break;
                    case 1:
                        Rule_1 rule_1 = new Rule_1((A) cur.getHolder());
                        stack.push(new ASTNode(rule_1.$2, rule_1, symbols.get(1), 2));
                        stack.push(new ASTNode(rule_1.$1, rule_1, symbols.get(0), 1));
                        break;
                    case 2:
                        Rule_2 rule_2 = new Rule_2((B) cur.getHolder());
                        stack.push(new ASTNode(rule_2.$1, rule_2, symbols.get(0), 1));
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
