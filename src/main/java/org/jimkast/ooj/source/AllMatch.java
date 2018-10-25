package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Check;
import org.jimkast.ooj.cond.Cond;

public final class AllMatch<T> implements Cond {
    private final PSource<T> source;

    public AllMatch(Check<T> check, PSource<T> source) {
        this(new PsFiltered<>(new Check.Not<>(check), source));
    }

    AllMatch(PSource<T> source) {
        this.source = source;
    }

    @Override
    public <X> X choose(X main, X other) {
        return source.feed(Target.Noop.instance()).choose(other, main);
    }
}
