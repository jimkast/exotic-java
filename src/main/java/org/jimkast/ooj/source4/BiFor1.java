package org.jimkast.ooj.source4;

import org.jimkast.ooj.map.Mapping;

public final class BiFor1<X, Y> implements Source<X> {
    private final BiSource<X, Y> bi;

    public BiFor1(BiSource<X, Y> bi) {
        this.bi = bi;
    }

    @Override
    public <X1> X1 feed(Mapping<X, X1> target, X1 other) {
        return bi.feed((x, y) -> target.map(x), other);
    }
}
