package Generated.Test.Rules;

import Generated.Test.Classes.*;

import Rules.ERule;

public class Rule_0 implements ERule {
    public A $0;
    public B $1;
    public A $2;
    public BS  $3;

    public Rule_0(A root) {
        $0 = root;
        $1 = new B();
        $2 = new A();
        $3 = new BS();
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
            case 3:
                f_3();
                break;
        }
    }

    private void f_1() {}

    private void f_2() {}

    private void f_3() { $0.xa = $2.xa + 1; }
}
