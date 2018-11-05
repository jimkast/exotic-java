package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Check;

public final class PsFiltered2<T> implements Source<T> {
    private final Check<T> check;
    private final CondSource<T> origin;

    public PsFiltered2(Check<T> check, Source<T> origin) {
        this(check, new CondSource.Default<>(origin));
    }

    public PsFiltered2(Check<T> check, CondSource<T> origin) {
        this.check = check;
        this.origin = origin;
    }

    @Override
    public void feed(Target<T> target) {
        while (origin.feed(new TrgCond<>(check, target, Target.Noop.instance())).choose(true, false)) ;
    }
}
