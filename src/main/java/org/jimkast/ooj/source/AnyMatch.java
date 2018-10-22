package org.jimkast.ooj.source;

import org.jimkast.ooj.lang.Check;
import org.jimkast.ooj.lang.Cond;
import org.jimkast.ooj.lang.PSource;
import org.jimkast.ooj.lang.Target;

public final class AnyMatch<T> implements Cond {
    private final PSource<T> source;

    public AnyMatch(Check<T> check, PSource<T> source) {
        this(new PsFiltered<>(check, source));
    }

    AnyMatch(PSource<T> source) {
        this.source = source;
    }

    @Override
    public <X> X choose(X main, X other) {
        return source.feed(Target.Noop.instance()).choose(main, other);
    }
}