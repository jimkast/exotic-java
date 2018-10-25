package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Check;
import org.jimkast.ooj.cond.Cond;

public final class PsMatchAll<T> implements Cond {
    private final PSource<T> source;

    public PsMatchAll(Check<T> check, PSource<T> source) {
        this(new PsFiltered<>(new Check.Not<>(check), source));
    }

    private PsMatchAll(PSource<T> source) {
        this.source = source;
    }

    @Override
    public <X> X choose(X main, X other) {
        return source.feed(Target.Noop.instance()).choose(other, main);
    }
}
