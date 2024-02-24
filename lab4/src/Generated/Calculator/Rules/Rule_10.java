package Generated.Calculator.Rules;

import Generated.Calculator.Classes.*;

import Rules.ERule;

public class Rule_10 implements ERule {
    public DIGIT $0;
    public NT  $1;
    public BS  $2;

    public Rule_10(DIGIT root) {
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

    private void f_2() { $0.digit = "0"; }
}
