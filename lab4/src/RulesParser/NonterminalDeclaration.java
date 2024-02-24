package RulesParser;

import java.util.List;

public class NonterminalDeclaration {
    String name;
    List<VarDeclaration> inh;
    List<VarDeclaration> synt;

    public NonterminalDeclaration(String name, List<VarDeclaration> inh, List<VarDeclaration> synt) {
        this.name = name;
        this.inh = inh;
        this.synt = synt;
    }

    public String getName() {
        return name;
    }

    public List<VarDeclaration> getInh() {
        return inh;
    }

    public List<VarDeclaration> getSynt() {
        return synt;
    }
}
