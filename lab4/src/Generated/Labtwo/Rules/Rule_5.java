package Generated.Labtwo.Rules;

import Generated.Labtwo.Classes.*;

import Rules.ERule;

public class Rule_5 implements ERule {
    public T $0;
    public F $1;
    public Tp $2;

    public Rule_5(T root) {
        $0 = root;
        $1 = new F();
        $2 = new Tp();
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

    private void f_2() {
    }
}
