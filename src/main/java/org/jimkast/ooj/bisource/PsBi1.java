package org.jimkast.ooj.bisource;

import org.jimkast.ooj.lang.BiPSource;
import org.jimkast.ooj.lang.Cond;
import org.jimkast.ooj.lang.PSource;
import org.jimkast.ooj.lang.Target;

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
