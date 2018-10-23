package org.jimkast.ooj.bisource;

import org.jimkast.ooj.lang.BiPSource;
import org.jimkast.ooj.lang.BiTarget;
import org.jimkast.ooj.lang.Cond;
import org.jimkast.ooj.lang.PSource;

public final class PsWithIndex<T> implements BiPSource<T, Integer> {
    private int i;
    private final PSource<T> origin;

    public PsWithIndex(PSource<T> origin) {
        this(0, origin);
    }

    public PsWithIndex(int i, PSource<T> origin) {
        this.i = i;
        this.origin = origin;
    }

    @Override
    public Cond feed(BiTarget<T, Integer> target) {
        return origin.feed(t -> target.accept(t, i++));
    }
}
