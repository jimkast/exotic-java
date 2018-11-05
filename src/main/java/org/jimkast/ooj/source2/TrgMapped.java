package org.jimkast.ooj.source2;

import org.jimkast.ooj.map.Mapping;
import org.jimkast.ooj.source.Target;

public final class TrgMapped<X, Y> implements Target<X> {
    private final Mapping<X, Y> mapping;
    private final Target<Y> origin;

    public TrgMapped(Mapping<X, Y> mapping, Target<Y> origin) {
        this.mapping = mapping;
        this.origin = origin;
    }

    @Override
    public void accept(X y) {
        origin.accept(mapping.map(y));
    }
}
