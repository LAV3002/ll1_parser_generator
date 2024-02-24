package Rules;

import Symbol.*;

import java.io.Serializable;
import java.util.*;

public class FFCalculator implements Serializable {
    List<Rule> rules;
    Map<NonterminalSymbol, Set<TerminalSymbol>> first;
    Map<NonterminalSymbol, Set<TerminalSymbol>> follow;

    Set<TerminalSymbol> terminals;
    Set<NonterminalSymbol> nonterminals;

    NonterminalSymbol start;


    final String epsTerm = "";
    final String endTerm = "$";

    public FFCalculator(List<Rule> rules) {
        this.rules = rules;
        this.first = new TreeMap<>();
        this.follow = new TreeMap<>();
        this.terminals = new TreeSet<>();
        this.terminals.addAll(Arrays.asList(new TerminalSymbol(epsTerm), new TerminalSymbol(endTerm)));
        this.nonterminals = new TreeSet<>();
        for (int i = 0; i < rules.size(); i++) {
            rules.get(i).setNumber(i);
        }
        for (Rule rule : rules) {
            nonterminals.add(rule.getLeft());
            for (Symbol symbol : rule.getRight()) {
                if (symbol.getType() == SymbolType.NONTERMINAL) {
                    nonterminals.add((NonterminalSymbol) symbol);
                }
                if (symbol.getType() == SymbolType.TERMINAL){
                    terminals.add((TerminalSymbol) symbol);
                }
            }
        }
        this.start = rules.get(0).left;
        calculate();
    }

    Set<TerminalSymbol> getFirst(NonterminalSymbol symbol) {
        return first.get(symbol);
    }

    Set<TerminalSymbol> getFollow(NonterminalSymbol symbol) {
        return follow.get(symbol);
    }

    Set<TerminalSymbol> getFirst(TerminalSymbol symbol) {
        return new TreeSet<>(List.of(symbol));
    }

    public Set<TerminalSymbol> getFirst(List<Symbol> symbols) {
        if (symbols.isEmpty()) {
            return new TreeSet<>(List.of(new TerminalSymbol("")));
        }
        Set<TerminalSymbol> toReturn = new TreeSet<>();
        boolean isEps = true;
        for (Symbol symbol : symbols) {
            if (symbol.getType() == SymbolType.NONTERMINAL) {
                toReturn.addAll(getFirst((NonterminalSymbol) symbol));
                if (getFirst((NonterminalSymbol) symbol).contains(new TerminalSymbol(epsTerm))) {
                    toReturn.remove(new TerminalSymbol(epsTerm));
                } else {
                    isEps = false;
                    break;
                }
            }
            if (symbol.getType() == SymbolType.TERMINAL) {
                assert symbol instanceof TerminalSymbol;
                toReturn.add((TerminalSymbol) symbol);
                isEps = false;
                break;
            }
        }
        if (isEps) {
            toReturn.add(new TerminalSymbol(epsTerm));
        }
        return toReturn;
    }

    public void calculate() {
        calculateFirst();
        calculateFollow();
    }

    void calculateFirst() {
        this.first = new TreeMap<>();
        for (Rule rule : this.rules) {
            this.first.put(rule.left, new TreeSet<>());
        }
        boolean changed = true;
        while (changed) {
            changed = false;
            for (Rule rule : this.rules) {
                changed |= this.first.get(rule.left).addAll(getFirst(rule.right));
            }
        }
    }

    void calculateFollow() {
        this.follow = new TreeMap<>();
        for (Rule rule : this.rules) {
            this.follow.put(rule.left, new TreeSet<>());
        }
        this.follow.get(this.start).add(new TerminalSymbol(endTerm));
        boolean changed = true;
        while (changed) {
            changed = false;
            for (Rule rule : this.rules) {
                int a = 1;
                for (int i = 0; i < rule.right.size(); i++) {
                    if (rule.right.get(i).getType() == SymbolType.NONTERMINAL) {
                        NonterminalSymbol B = (NonterminalSymbol) rule.right.get(i);
                        List<Symbol> G = rule.right.subList(i + 1, rule.right.size());
                        Set<TerminalSymbol> toAdd = getFirst(G);
                        boolean eps = toAdd.contains(new TerminalSymbol(epsTerm));
                        toAdd.remove(new TerminalSymbol(epsTerm));
                        changed |= this.follow.get(B).addAll(toAdd);
                        if (eps) {
                            changed |= this.follow.get(B).addAll(this.follow.get(rule.left));
                        }
                    }
                }
            }
        }
    }

    public boolean checkLL1() {
        Map<NonterminalSymbol, List<List<Symbol>>> ruleMap = new TreeMap<>();
        for (Rule rule : rules) {
            ruleMap.put(rule.left, new ArrayList<>());
        }
        for (Rule rule : rules) {
            ruleMap.get(rule.left).add(rule.right);
        }
        boolean good = true;
        for (NonterminalSymbol left : ruleMap.keySet()) {
            for (List<Symbol> first : ruleMap.get(left)) {
                for (List<Symbol> second : ruleMap.get(left)) {
                    if (!first.equals(second)) {
                        good &= Collections.disjoint(getFirst(first), getFirst(second));
                    }
                    if (getFirst(first).contains(new TerminalSymbol(epsTerm))) {
                        good &= Collections.disjoint(getFollow(left), getFirst(second));
                    }
                }
            }
        }
        return good;
    }

    public Map<NonterminalSymbol, Set<TerminalSymbol>> getFirst() {
        return first;
    }

    public void setFirst(Map<NonterminalSymbol, Set<TerminalSymbol>> first) {
        this.first = first;
    }

    public Map<NonterminalSymbol, Set<TerminalSymbol>> getFollow() {
        return follow;
    }

    public void setFollow(Map<NonterminalSymbol, Set<TerminalSymbol>> follow) {
        this.follow = follow;
    }

    public Set<TerminalSymbol> getTerminals() {
        return terminals;
    }

    public void setTerminals(Set<TerminalSymbol> terminals) {
        this.terminals = terminals;
    }

    public Set<NonterminalSymbol> getNonterminals() {
        return nonterminals;
    }

    public void setNonterminals(Set<NonterminalSymbol> nonterminals) {
        this.nonterminals = nonterminals;
    }

    public NonterminalSymbol getStart() {
        return start;
    }

    public void setStart(NonterminalSymbol start) {
        this.start = start;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public String getEpsTerm() {
        return epsTerm;
    }

    public String getEndTerm() {
        return endTerm;
    }
}
