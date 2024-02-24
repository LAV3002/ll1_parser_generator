package Generated.Labtwo.Rules;

import Generated.Labtwo.Classes.*;

import Rules.ERule;

public class Rule_2 implements ERule {
    public Ep $0;
    public NT  $1;
    public T $2;
    public Ep $3;

    public Rule_2(Ep root) {
        $0 = root;
        $1 = new NT();
        $2 = new T();
        $3 = new Ep();
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

    private void f_3() {
    }
}
