package Symbol;

import java.io.Serializable;

public interface Symbol extends Comparable<Symbol>, Serializable {
    String getValue();
    String getCode();

    SymbolType getType();
}
