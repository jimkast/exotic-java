package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Cond;

public final class PsNotEmpty<T> implements Cond {
    private final CondSource<T> source;
    private final Target<T> target;

    public PsNotEmpty(Source<T> source) {
        this(source, Target.Noop.instance());
    }

    public PsNotEmpty(Source<T> source, Target<T> target) {
        this(new CondSource.Default<>(source), target);
    }

    public PsNotEmpty(CondSource<T> source, Target<T> target) {
        this.source = source;
        this.target = target;
    }

    @Override
    public <X> X choose(X main, X other) {
        return source.feed(target).choose(main, other);
    }
}
