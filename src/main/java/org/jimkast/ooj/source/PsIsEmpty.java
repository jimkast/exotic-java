package org.jimkast.ooj.source;

import org.jimkast.ooj.cond.Cond;

public final class PsIsEmpty<X> implements Cond {
    private final PSource<X> source;

    public PsIsEmpty(PSource<X> source) {
        this.source = source;
    }

    @Override
    public <T> T choose(T main, T other) {
        return source.feed(Target.Noop.instance()).choose(main, other);
    }
}
