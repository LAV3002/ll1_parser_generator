package Generated.Labtwo.Rules;

import Generated.Labtwo.Classes.*;

import Rules.ERule;

public class Rule_8 implements ERule {
    public F $0;
    public Fp $1;
    public K $2;

    public Rule_8(F root) {
        $0 = root;
        $1 = new Fp();
        $2 = new K();
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
