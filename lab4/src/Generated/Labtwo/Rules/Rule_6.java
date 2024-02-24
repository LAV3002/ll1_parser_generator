package Generated.Labtwo.Rules;

import Generated.Labtwo.Classes.*;

import Rules.ERule;

public class Rule_6 implements ERule {
    public Tp $0;
    public NT  $1;
    public F $2;
    public Tp $3;

    public Rule_6(Tp root) {
        $0 = root;
        $1 = new NT();
        $2 = new F();
        $3 = new Tp();
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
