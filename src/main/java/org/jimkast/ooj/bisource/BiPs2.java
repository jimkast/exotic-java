package org.jimkast.ooj.bisource;

import org.jimkast.ooj.cond.Cond;
import org.jimkast.ooj.lang.Array;
import org.jimkast.ooj.source.PSource;

public final class BiPs2<T> implements BiPSource<T, T> {
    private final PSource<Array<T>> origin;

    public BiPs2(T t, PSource<T> origin) {
        this(new BiPsN<>(origin, t));
    }

    public BiPs2(PSource<Array<T>> origin) {
        this.origin = origin;
    }

    @Override
    public Cond feed(BiTarget<T, T> target) {
        return origin.feed(tArray -> target.accept(tArray.map(0), tArray.map(1)));
    }
}
