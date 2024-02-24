package Rules;

import Symbol.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Rule implements Serializable {
    NonterminalSymbol left;
    List<Symbol> right;


    Integer number;

    public Rule(NonterminalSymbol left, List<Symbol> right) {
        this.left = left;
        this.right = right;
        this.number = 0;
    }

    public Rule(String left, List<Symbol> right) {
        this.left = new NonterminalSymbol(left);
        this.right = right;
        this.number = 0;
    }

    public Rule(NonterminalSymbol left, Integer number) {
        this.left = left;
        this.right = new ArrayList<>();
        this.number = number;
    }

    public void extendRight(Symbol symbol) {
        right.add(symbol);
    }
//    public void extendAssignments(Operation assignment) {assignments.add(assignment);}

    public NonterminalSymbol getLeft() {
        return left;
    }

    public void setLeft(NonterminalSymbol left) {
        this.left = left;
    }

    public List<Symbol> getRight() {
        return right;
    }

    public void setRight(List<Symbol> right) {
        this.right = right;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(number);
        out.append(": ");
        out.append(left);
        out.append(" -> ");
        for (Symbol symbol : right) {
            out.append(symbol).append(" ");
        }
        return out.toString();
    }
}
