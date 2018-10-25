package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Cond;

public final class PsEndless<T> implements PSource<T> {
    private final Source<T> source;

    public PsEndless(T t) {
        this(new Source.Fixed<>(t));
    }

    public PsEndless(Source<T> source) {
        this.source = source;
    }

    @Override
    public Cond feed(Target<T> target) {
        source.feed(target);
        return Cond.TRUE;
    }
}
