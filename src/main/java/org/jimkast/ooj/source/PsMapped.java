package org.jimkast.ooj.source;

import org.jimkast.ooj.map.Mapping;
import org.jimkast.ooj.source2.TrgMapped;

public final class PsMapped<X, Y> implements Source<Y> {
    private final Mapping<X, Y> mapping;
    private final Source<X> origin;

    public PsMapped(Mapping<X, Y> mapping, Source<X> origin) {
        this.mapping = mapping;
        this.origin = origin;
    }

    @Override
    public void feed(Target<Y> target) {
        origin.feed(new TrgMapped<>(mapping, target));
    }
}
