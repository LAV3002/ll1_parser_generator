package RulesParser;

import Rules.Rule;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RulesWalker extends RulesBaseListener {
    private List<Rule> rules;
    private List<NonterminalDeclaration> declarations;

    private final Set<String> tokens = new TreeSet<>();

    public RulesWalker() {
        this.rules = new ArrayList<>();
        this.declarations = new ArrayList<>();
    }

    public void exitRules(RulesParser.RulesContext ctx) {
        rules = ctx.res;
        for (int i = 0; i < rules.size(); i++) {
            rules.get(i).setNumber(i);
        }
    }

    public void exitDeclaration(RulesParser.DeclarationContext ctx) {
        declarations = ctx.res;
    }

//    public void enterLeft(RulesParser.LeftContext ctx) {
//        System.out.println("Left: " + ctx.NONTERMINAL().getText());
//        rules.add(new Rule(new NonterminalSymbol(ctx.NONTERMINAL().getText()), rules.size()));
//    }
//
//    public void enterOperation(RulesParser.OperationContext ctx) {
//        Operand dst = getOperand(ctx.LITERAL(0).getText());
//        Operand src1 = getOperand(ctx.LITERAL(1).getText());
//        Operand src2 = getOperand(ctx.LITERAL(2).getText());
////        rules.get(rules.size() - 1).extendRight(new BroadcastingSymbol(new Operation(dst, src1, src2, ctx.children.get(3).getText())));
//    }
//
//    private Operand getOperand(String data) {
//        if (Character.isDigit(data.charAt(0))) {
//            return new Operand(Integer.valueOf(data), OpType.LITERAL);
//        }
//        Integer num = Integer.valueOf(data.substring(1));
//        Character type = data.charAt(0);
//        if (type.equals('$')) {
//            return new Operand(num, OpType.SYNT);
//        } else {
//            return new Operand(num, OpType.INH);
//        }
//    }
//
//    public void enterSymbol(RulesParser.SymbolContext ctx) {
//        TerminalNode nonterminal = ctx.NONTERMINAL();
//        TerminalNode terminal = ctx.TERMINAL();
//        if (nonterminal != null) {
//            String text = ctx.NONTERMINAL().getText();
//            rules.get(rules.size() - 1).extendRight(new NonterminalSymbol(text));
//            System.out.println("Right(N, " + rules.size() + "): " + text);
//        }
//        if (terminal != null) {
//            String text = ctx.TERMINAL().getText();
//            rules.get(rules.size() - 1).extendRight(new TerminalSymbol(text.substring(1, text.length() - 1)));
//            System.out.println("Right(T, " + rules.size() + "): " + text);
//            tokens.add(text);
//        }
//    }


    public List<Rule> getRules() {
        return rules;
    }
    public List<NonterminalDeclaration> getDeclarations() {
        return declarations;
    }
    public Set<String> getTokens() {
        return tokens;
    }
}
