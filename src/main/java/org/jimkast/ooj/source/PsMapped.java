package org.jimkast.ooj.source;

import org.jimkast.ooj.lang.Cond;
import org.jimkast.ooj.lang.Mapping;
import org.jimkast.ooj.lang.PSource;
import org.jimkast.ooj.lang.Target;

public final class PsMapped<X, Y> implements PSource<Y> {
    private final Mapping<X, Y> mapping;
    private final PSource<X> origin;

    public PsMapped(Mapping<X, Y> mapping, PSource<X> origin) {
        this.mapping = mapping;
        this.origin = origin;
    }

    @Override
    public Cond feed(Target<Y> target) {
        return origin.feed(new TrgMapped<>(mapping, target));
    }
}
