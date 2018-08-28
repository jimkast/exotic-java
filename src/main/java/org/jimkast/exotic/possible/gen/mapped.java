package org.jimkast.exotic.possible.gen;

import org.cactoos.Func;
import org.cactoos.Scalar;

public final class mapped<X, Y> implements Scalar<Y> {
    private final Func<X, Y> mapper;
    private final Scalar<X> origin;

    public mapped(Func<X, Y> mapper, Scalar<X> origin) {
        this.mapper = mapper;
        this.origin = origin;
    }

    @Override
    public Y value() throws Exception {
        return mapper.apply(origin.value());
    }
}
