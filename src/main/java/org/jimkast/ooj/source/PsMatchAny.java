package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Check;
import org.jimkast.ooj.cond.Cond;
import org.jimkast.ooj.source.PSource;
import org.jimkast.ooj.source.PsFiltered;
import org.jimkast.ooj.source.Target;

public final class PsMatchAny<T> implements Cond {
    private final PSource<T> source;

    public PsMatchAny(T item, PSource<T> source) {
        this(new PsFiltered<>(t -> item == t ? TRUE : FALSE, source));
    }

    public PsMatchAny(Check<T> check, PSource<T> source) {
        this(new PsFiltered<>(check, source));
    }

    private PsMatchAny(PSource<T> source) {
        this.source = source;
    }

    @Override
    public <X> X choose(X main, X other) {
        return source.feed(Target.Noop.instance()).choose(main, other);
    }
}
