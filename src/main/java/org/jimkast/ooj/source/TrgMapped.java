package org.jimkast.ooj.source;

import org.jimkast.ooj.lang.Mapping;
import org.jimkast.ooj.lang.Target;

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
