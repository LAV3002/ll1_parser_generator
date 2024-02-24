package Generated.Test.Rules;

import Generated.Test.Classes.*;

import Rules.ERule;

public class Rule_1 implements ERule {
    public A $0;
    public NT  $1;
    public BS  $2;

    public Rule_1(A root) {
        $0 = root;
        $1 = new NT();
        $2 = new BS();
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

    private void f_1() {}

    private void f_2() { $0.xa = 0; }
}
