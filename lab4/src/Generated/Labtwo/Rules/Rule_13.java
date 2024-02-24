package Generated.Labtwo.Rules;

import Generated.Labtwo.Classes.*;

import Rules.ERule;

public class Rule_13 implements ERule {
    public Kp $0;
    public NT  $1;
    public M $2;

    public Rule_13(Kp root) {
        $0 = root;
        $1 = new NT();
        $2 = new M();
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

    private void f_2() {
    }
}
