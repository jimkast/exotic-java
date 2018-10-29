package org.jimkast.ooj.bisource;

import org.jimkast.ooj.cond.Cond;
import org.jimkast.ooj.source.PSource;

public final class PsBiCombined2<X, Y> implements BiPSource<X, Y> {
    private final PSource<X> p1;
    private final PSource<Y> p2;

    public PsBiCombined2(PSource<X> p1, PSource<Y> p2) {
        this.p1 = p1;
        this.p2 = p2;
    }


    @Override
    public Cond feed(BiTarget<X, Y> target) {
        return p1.feed(x -> p2.feed(y -> target.accept(x, y)));
    }
}
