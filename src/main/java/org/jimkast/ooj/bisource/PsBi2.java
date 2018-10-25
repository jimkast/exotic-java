package org.jimkast.ooj.bisource;

import org.jimkast.ooj.cond.Cond;
import org.jimkast.ooj.source.PSource;
import org.jimkast.ooj.source.Target;

public final class PsBi2<T> implements PSource<T> {
    private final BiPSource<?, T> origin;

    public PsBi2(BiPSource<?, T> origin) {
        this.origin = origin;
    }

    @Override
    public Cond feed(Target<T> target) {
        return origin.feed((o, t) -> target.accept(t));
    }
}
