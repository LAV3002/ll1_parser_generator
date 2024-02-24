package Generated.Test.Rules;

import Generated.Test.Classes.*;

import Rules.ERule;

public class Rule_2 implements ERule {
    public B $0;
    public NT  $1;

    public Rule_2(B root) {
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
