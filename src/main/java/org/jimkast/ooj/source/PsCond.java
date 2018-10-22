package org.jimkast.ooj.source;

import org.jimkast.ooj.lang.Check;
import org.jimkast.ooj.lang.Cond;
import org.jimkast.ooj.lang.PSource;
import org.jimkast.ooj.lang.Target;

public final class PsCond<T> implements PSource<T> {
    private final Check<T> check;
    private final Target<T> other;
    private final PSource<T> origin;

    public PsCond(Check<T> check, PSource<T> origin) {
        this(check, Target.Noop.instance(), origin);
    }

    public PsCond(Check<T> check, Target<T> other, PSource<T> origin) {
        this.check = check;
        this.other = other;
        this.origin = origin;
    }

    @Override
    public Cond feed(Target<T> target) {
        return origin.feed(new TrgCond<>(check, target, other));
    }
}
