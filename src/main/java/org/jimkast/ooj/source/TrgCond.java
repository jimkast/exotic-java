package org.jimkast.ooj.source;

import org.jimkast.ooj.lang.Check;
import org.jimkast.ooj.lang.Target;

public final class TrgCond<T> implements Target<T> {
    private final Check<T> check;
    private final Target<T> main;
    private final Target<T> other;

    public TrgCond(Check<T> check, Target<T> main, Target<T> other) {
        this.check = check;
        this.main = main;
        this.other = other;
    }

    @Override
    public void accept(T t) {
        check.test(t).choose(main, other).accept(t);
    }
}
