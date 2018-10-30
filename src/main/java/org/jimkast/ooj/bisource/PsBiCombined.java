package org.jimkast.ooj.bisource;

import org.jimkast.ooj.source.Source;

public final class PsBiCombined<X, Y> implements BiSource<X, Y> {
    private final Source<X> p1;
    private final Source<Y> p2;

    public PsBiCombined(Source<X> p1, Source<Y> p2) {
        this.p1 = p1;
        this.p2 = p2;
    }


    @Override
    public void feed(BiTarget<X, Y> target) {
        p1.feed(x -> p2.feed(y -> target.accept(x, y)));
    }
}
