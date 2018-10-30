package org.jimkast.ooj.bisource;

import org.jimkast.ooj.map.Mapping;
import org.jimkast.ooj.source.Source;

public final class PsBiCombined<X, Y> implements BiSource<X, Y> {
    private final Source<X> p1;
    private final Mapping<X, Y> p2;

    public PsBiCombined(Source<X> p1, Mapping<X, Y> p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public void feed(BiTarget<X, Y> target) {
        p1.feed(x -> target.accept(x, p2.map(x)));
    }
}
