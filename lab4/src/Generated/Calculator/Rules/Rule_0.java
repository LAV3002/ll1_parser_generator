package Generated.Calculator.Rules;

import Generated.Calculator.Classes.*;

import Rules.ERule;

public class Rule_0 implements ERule {
    public E $0;
    public T $1;
    public Ep $2;
    public BS  $3;

    public Rule_0(E root) {
        $0 = root;
        $1 = new T();
        $2 = new Ep();
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
