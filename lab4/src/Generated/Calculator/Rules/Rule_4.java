package Generated.Calculator.Rules;

import Generated.Calculator.Classes.*;

import Rules.ERule;

public class Rule_4 implements ERule {
    public Tp $0;
    public NT  $1;
    public F $2;
    public BS  $3;
    public Tp $4;
    public BS  $5;

    public Rule_4(Tp root) {
        $0 = root;
        $1 = new NT();
        $2 = new F();
        $3 = new BS();
        $4 = new Tp();
        $5 = new BS();
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
            case 5:
                f_5();
                break;
        }
    }

    private void f_1() {}

    private void f_2() {
    }

    private void f_3() { $4.acc = $0.acc * $2.res; }

    private void f_4() {
$4.acc = $4.acc;
    }

    private void f_5() { $0.res = $4.res; }
}
