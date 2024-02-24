package Symbol;

import Symbol.Symbol;

import java.util.ArrayList;
import java.util.List;

public class NonterminalSymbol implements Symbol {
    final String value;
    final List<String> assignments;
    final SymbolType type = SymbolType.NONTERMINAL;

    public NonterminalSymbol(String value, List<String> assignments) {
        this.value = value;
        this.assignments = assignments;
    }

    public NonterminalSymbol(String value) {
        this.value = value;
        this.assignments = new ArrayList<>();
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getCode() {
        return "";
    }

    @Override
    public SymbolType getType() {
        return type;
    }

    @Override
    public int compareTo(Symbol o) {
        return getValue().compareTo(o.getValue());
    }

    @Override
    public String toString() {
        return getValue();
    }

    public List<String> getAssignments() {
        return assignments;
    }
}
