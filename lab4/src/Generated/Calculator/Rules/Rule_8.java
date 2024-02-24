package Generated.Calculator.Rules;

import Generated.Calculator.Classes.*;

import Rules.ERule;

public class Rule_8 implements ERule {
    public NUMBER $0;
    public DIGIT $1;
    public NUMBER $2;
    public BS  $3;

    public Rule_8(NUMBER root) {
        $0 = root;
        $1 = new DIGIT();
        $2 = new NUMBER();
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

    private void f_1() {
    }

    private void f_2() {
    }

    private void f_3() { $0.number = $1.digit + $2.number; }
}
