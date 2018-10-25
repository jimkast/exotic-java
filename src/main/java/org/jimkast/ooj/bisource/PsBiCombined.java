package org.jimkast.ooj.bisource;

import org.jimkast.ooj.cond.Cond;
import org.jimkast.ooj.map.Mapping;
import org.jimkast.ooj.source.PSource;

public final class PsBiCombined<X, Y> implements BiPSource<X, Y> {
    private final PSource<X> p1;
    private final Mapping<X, Y> p2;

    public PsBiCombined(PSource<X> p1, Mapping<X, Y> p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public Cond feed(BiTarget<X, Y> target) {
        return p1.feed(x -> target.accept(x, p2.map(x)));
    }
}
