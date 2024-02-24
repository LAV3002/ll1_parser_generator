package Generated.Labtwo.Rules;

import Generated.Labtwo.Classes.*;

import Rules.ERule;

public class Rule_15 implements ERule {
    public M $0;
    public NT  $1;
    public E $2;
    public NT  $3;

    public Rule_15(M root) {
        $0 = root;
        $1 = new NT();
        $2 = new E();
        $3 = new NT();
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

    private void f_2() {
    }

    private void f_3() {}
}
