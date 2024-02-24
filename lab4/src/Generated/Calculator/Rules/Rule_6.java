package Generated.Calculator.Rules;

import Generated.Calculator.Classes.*;

import Rules.ERule;

public class Rule_6 implements ERule {
    public F $0;
    public NUMBER $1;
    public BS  $2;

    public Rule_6(F root) {
        $0 = root;
        $1 = new NUMBER();
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

    private void f_1() {
    }

    private void f_2() { $0.res = Integer.valueOf($1.number); }
}
