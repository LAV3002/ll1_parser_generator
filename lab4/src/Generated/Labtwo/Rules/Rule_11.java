package Generated.Labtwo.Rules;

import Generated.Labtwo.Classes.*;

import Rules.ERule;

public class Rule_11 implements ERule {
    public K $0;
    public M $1;
    public Kp $2;

    public Rule_11(K root) {
        $0 = root;
        $1 = new M();
        $2 = new Kp();
    }

    @Override
    public void execute(Integer pos) {
        switch (pos) {
            case 1:
                f_1();
                break;
            case 2:
                f_2();
                break;
        }
    }

    private void f_1() {
    }

    private void f_2() {
    }
}
