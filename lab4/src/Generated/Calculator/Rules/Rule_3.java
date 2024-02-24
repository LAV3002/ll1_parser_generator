package Generated.Calculator.Rules;

import Generated.Calculator.Classes.*;

import Rules.ERule;

public class Rule_3 implements ERule {
    public T $0;
    public F $1;
    public Tp $2;
    public BS  $3;

    public Rule_3(T root) {
        $0 = root;
        $1 = new F();
        $2 = new Tp();
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
$2.acc = $1.res;
    }

    private void f_3() { $0.res = $2.res; }
}
