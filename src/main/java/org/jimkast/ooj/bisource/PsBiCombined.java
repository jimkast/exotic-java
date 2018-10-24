package org.jimkast.ooj.bisource;

import org.jimkast.ooj.lang.BiPSource;
import org.jimkast.ooj.lang.BiTarget;
import org.jimkast.ooj.lang.Cond;
import org.jimkast.ooj.lang.PSource;
import org.jimkast.ooj.lang.Source;

public final class PsBiCombined<X, Y> implements BiPSource<X, Y> {
    private final PSource<X> p1;
    private final Source<Y> p2;

    public PsBiCombined(PSource<X> p1, Source<Y> p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public Cond feed(BiTarget<X, Y> target) {
        return p1.feed(x -> p2.feed(y -> target.accept(x, y)));
    }
}
