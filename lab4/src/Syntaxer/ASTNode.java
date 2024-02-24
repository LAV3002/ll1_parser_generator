package Syntaxer;

import Rules.ERule;
import Symbol.*;

import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.model.MutableNode;
import static guru.nidi.graphviz.model.Factory.*;

import java.util.ArrayList;
import java.util.List;

public class ASTNode {
    Object holder;
    ERule rule;
    Symbol node;
    List <ASTNode> children;
    public Integer inRulePos;

    static Integer nodeCounter = 0;

    public ASTNode(Object holder, ERule rule, Symbol node, Integer inRulePos) {
        this.holder = holder;
        this.rule = rule;
        this.node = node;
        children = new ArrayList<>();
        this.inRulePos = inRulePos;
    }

    public MutableGraph toGraph() {
        return mutGraph("example1").setDirected(true).add(this.toNode());
    }

    private MutableNode toNode() {
        MutableNode topNode = mutNode(this.node.getValue() + " " + nodeCounter++);
        for (ASTNode child : children) {
            topNode.addLink(child.toNode());
        }
        return topNode;
    }

    public void addChild(ASTNode child) {
        children.add(child);
    }

    public Object getHolder() {
        return holder;
    }

    public ERule getRule() {
        return rule;
    }

    public Symbol getNode() {
        return node;
    }

    public List<ASTNode> getChildren() {
        return children;
    }
}
