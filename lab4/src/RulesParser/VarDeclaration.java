package RulesParser;

public class VarDeclaration {
    public String type;
    public String name;

    public VarDeclaration(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
