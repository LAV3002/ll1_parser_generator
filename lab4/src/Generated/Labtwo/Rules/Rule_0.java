package Generated.Labtwo.Rules;

import Generated.Labtwo.Classes.*;

import Rules.ERule;

public class Rule_0 implements ERule {
    public E $0;
    public T $1;
    public Ep $2;

    public Rule_0(E root) {
        $0 = root;
        $1 = new T();
        $2 = new Ep();
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
