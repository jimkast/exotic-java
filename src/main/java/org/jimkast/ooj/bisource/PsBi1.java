package org.jimkast.ooj.bisource;

import org.jimkast.ooj.cond.Cond;
import org.jimkast.ooj.source.PSource;
import org.jimkast.ooj.source.Target;

public final class PsBi1<T> implements PSource<T> {
    private final BiPSource<T, ?> origin;

    public PsBi1(BiPSource<T, ?> origin) {
        this.origin = origin;
    }

    @Override
    public Cond feed(Target<T> target) {
        return origin.feed((t, o) -> target.accept(t));
    }
}
