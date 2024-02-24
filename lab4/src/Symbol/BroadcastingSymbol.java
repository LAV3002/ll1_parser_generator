package Symbol;

import java.util.ArrayList;
import java.util.List;

public class BroadcastingSymbol implements Symbol {
    final String value;

    final SymbolType type = SymbolType.BROADCASTING;

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getCode() {
        return value;
    }

    public BroadcastingSymbol(String value) {
        this.value = value.substring(1, value.length() - 1);
    }

    @Override
    public SymbolType getType() {
        return type;
    }

    @Override
    public int compareTo(Symbol o) {
        return getValue().compareTo(o.getValue());
    }

}
