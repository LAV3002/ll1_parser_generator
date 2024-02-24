package Syntaxer;

import Rules.FFCalculator;
import Rules.Rule;
import Symbol.NonterminalSymbol;
import Symbol.TerminalSymbol;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ParseTable {
    private final Map<NonterminalSymbol, Map<TerminalSymbol, Rule>> table;
    Set<TerminalSymbol> terminals;
    Set<NonterminalSymbol> nonterminals;

    NonterminalSymbol start;

    public ParseTable(List<Rule> rules, FFCalculator calculator) {
        this.table = new TreeMap<>();
        for (Rule rule : rules) {
            if (!table.containsKey(rule.getLeft())) {
                table.put(rule.getLeft(), new TreeMap<>());
            }
            Set<TerminalSymbol> first = calculator.getFirst(rule.getRight());
            if (first.size() == 1 && first.contains(new TerminalSymbol(""))) {
                for (TerminalSymbol terminalSymbol : calculator.getFollow().get(rule.getLeft())) {
                    table.get(rule.getLeft()).put(terminalSymbol, rule);
                }
            } else {
                for (TerminalSymbol terminalSymbol : first) {
                    table.get(rule.getLeft()).put(terminalSymbol, rule);
                }
            }
        }
        terminals = calculator.getTerminals();
        nonterminals = calculator.getNonterminals();
        start = calculator.getStart();
    }

    public Rule getRule(NonterminalSymbol nonterminalSymbol, TerminalSymbol terminalSymbol) {
        return table.get(nonterminalSymbol).get(terminalSymbol);
    }

    @Override
    public String toString() {
        int width = Integer.max(terminals.stream().map(s -> s.toString().length()).max(Integer::compareTo).orElse(0),
                nonterminals.stream().map(s -> s.toString().length()).max(Integer::compareTo).orElse(0));
        width = Integer.max(width, Integer.toString(table.size()).length());
        StringBuilder out = new StringBuilder();
        out.append("-".repeat((terminals.size() + 1) * width + terminals.size()));
        out.append("\n");
        out.append(" ".repeat(width)).append("|");
        for (TerminalSymbol terminal : terminals) {
            out.append(String.format("%" + width + "s|", terminal));
        }
        out.append("\n");
        out.append("-".repeat((terminals.size() + 1) * width + terminals.size()));
        out.append("\n");
        for (NonterminalSymbol nonterminal : nonterminals) {
            out.append(String.format("%" + width + "s|", nonterminal));
            for (TerminalSymbol terminal : terminals) {
                Rule to = table.get(nonterminal).get(terminal);
                if (to == null) {
                    out.append(String.format("%" + width + "s|", ""));
                } else {
                    out.append(String.format("%" + width + "s|", to.getNumber()));
                }
            }
            out.append("\n");
            out.append("-".repeat((terminals.size() + 1) * width + terminals.size()));
            out.append("\n");
        }
        return out.toString();
    }

    public Set<TerminalSymbol> getTerminals() {
        return terminals;
    }

    public void setTerminals(Set<TerminalSymbol> terminals) {
        this.terminals = terminals;
    }

    public NonterminalSymbol getStart() {
        return start;
    }

    public void setStart(NonterminalSymbol start) {
        this.start = start;
    }
}
