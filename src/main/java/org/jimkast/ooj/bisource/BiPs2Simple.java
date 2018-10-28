package org.jimkast.ooj.bisource;

import org.jimkast.ooj.cond.Cond;
import org.jimkast.ooj.source.PSource;

public final class BiPs2Simple<T> implements BiPSource<T, T> {
    private final PSource<T> origin;

    public BiPs2Simple(PSource<T> origin) {
        this.origin = origin;
    }

    @Override
    public Cond feed(BiTarget<T, T> target) {
        return origin.feed(t -> origin.feed(t2 -> target.accept(t, t2)));
    }
}
