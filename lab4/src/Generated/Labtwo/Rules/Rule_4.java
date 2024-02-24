package Generated.Labtwo.Rules;

import Generated.Labtwo.Classes.*;

import Rules.ERule;

public class Rule_4 implements ERule {
    public Ep $0;
    public NT  $1;

    public Rule_4(Ep root) {
        $0 = root;
        $1 = new NT();
    }

    @Override
    public void execute(Integer pos) {
        switch (pos) {
            case 1:
                f_1();
                break;
        }
    }

    private void f_1() {}
}
