package org.jimkast.exotic.possible;

import java.util.function.Consumer;
import java.util.function.Function;

public final class mapped<X, Y> implements possible<Y> {
    private final Function<X, Y> mapper;
    private final possible<X> origin;

    public mapped(Function<X, Y> mapper, possible<X> origin) {
        this.mapper = mapper;
        this.origin = origin;
    }

    @Override
    public void supply(Consumer<? super Y> consumer) {
        origin.supply(x -> consumer.accept(mapper.apply(x)));
    }
}
