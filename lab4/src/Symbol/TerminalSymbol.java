package Symbol;

public class TerminalSymbol implements Symbol {
    final String value;
    final SymbolType type = SymbolType.TERMINAL;

    public TerminalSymbol(String value) {
        this.value = value;
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
        if (getValue().equals("")) {
            return "$eps$";
        }
        return getValue();
    }
}
