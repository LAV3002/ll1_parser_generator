package Generated.Calculator.Rules;

import Generated.Calculator.Classes.*;

import Rules.ERule;

public class Rule_7 implements ERule {
    public F $0;
    public NT  $1;
    public E $2;
    public NT  $3;
    public BS  $4;

    public Rule_7(F root) {
        $0 = root;
        $1 = new NT();
        $2 = new E();
        $3 = new NT();
        $4 = new BS();
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
            case 4:
                f_4();
                break;
        }
    }

    private void f_1() {}

    private void f_2() {
    }

    private void f_3() {}

    private void f_4() { $0.res = $2.res; }
}
