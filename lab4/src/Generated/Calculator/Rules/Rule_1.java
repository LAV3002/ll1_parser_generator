package Generated.Calculator.Rules;

import Generated.Calculator.Classes.*;

import Rules.ERule;

public class Rule_1 implements ERule {
    public Ep $0;
    public NT  $1;
    public T $2;
    public BS  $3;
    public Ep $4;
    public BS  $5;

    public Rule_1(Ep root) {
        $0 = root;
        $1 = new NT();
        $2 = new T();
        $3 = new BS();
        $4 = new Ep();
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

    private void f_3() { $4.acc = $0.acc + $2.res; }

    private void f_4() {
$4.acc = $4.acc;
    }

    private void f_5() { $0.res = $4.res; }
}
