package org.jimkast.ooj.source4;

import org.jimkast.ooj.map.BiMapping;

public final class Combined<X, Y> implements BiSource<X, Y> {
    private final Source<X> s1;
    private final Source<Y> s2;

    public Combined(Source<X> s1, Source<Y> s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public <Z> Z feed(BiMapping<X, Y, Z> target, Z other) {
        return s1.feed(x -> s2.feed(y -> target.map(x, y), other), other);
    }
}
