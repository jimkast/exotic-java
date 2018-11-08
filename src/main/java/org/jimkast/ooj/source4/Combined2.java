package org.jimkast.ooj.source4;

import org.jimkast.ooj.map.BiMapping;
import org.jimkast.ooj.map.Mapping;

public final class Combined2<X, Y> implements BiSource<X, Y> {
    private final Mapping<X, Y> mapping;
    private final Source<X> s1;

    public Combined2(Mapping<X, Y> mapping, Source<X> s1) {
        this.mapping = mapping;
        this.s1 = s1;
    }

    @Override
    public <Z> Z feed(BiMapping<X, Y, Z> target, Z other) {
        return s1.feed(x -> target.map(x, mapping.map(x)), other);
    }
}
