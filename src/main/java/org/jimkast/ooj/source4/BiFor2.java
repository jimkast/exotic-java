package org.jimkast.ooj.source4;

import org.jimkast.ooj.map.Mapping;

public final class BiFor2<X, Y> implements Source<Y> {
    private final BiSource<X, Y> bi;

    public BiFor2(BiSource<X, Y> bi) {
        this.bi = bi;
    }

    @Override
    public <X1> X1 feed(Mapping<Y, X1> target, X1 other) {
        return bi.feed((x, y) -> target.map(y), other);
    }
}
