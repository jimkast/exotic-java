package org.jimkast.ooj.bisource;

import org.jimkast.ooj.lang.Array;
import org.jimkast.ooj.source.Source;

public final class BiPs2<T> implements BiSource<T, T> {
    private final Source<Array<T>> origin;

    public BiPs2(T t, Source<T> origin) {
        this(new BiPsN<>(origin, t));
    }

    public BiPs2(Source<Array<T>> origin) {
        this.origin = origin;
    }

    @Override
    public void feed(BiTarget<T, T> target) {
        origin.feed(tArray -> target.accept(tArray.map(0), tArray.map(1)));
    }
}
