package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Check;

public final class PsWhile<T> implements Source<T> {
    private final Check<T> check;
    private final Target<T> other;
    private final Source<T> origin;

    public PsWhile(Check<T> check, Source<T> origin) {
        this(check, Target.Noop.instance(), origin);
    }

    public PsWhile(Check<T> check, Target<T> other, Source<T> origin) {
        this.check = check;
        this.other = other;
        this.origin = origin;
    }

    @Override
    public void feed(Target<T> target) {
        origin.feed(new TrgCond<>(check, target, other));
    }
}
