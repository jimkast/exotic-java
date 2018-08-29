package org.jimkast.exotic.possible.index;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import org.jimkast.exotic.possible.possible;

public final class mapped_with_index<X, Y> implements possible<Y> {
    private final BiFunction<X, Integer, Y> mapper;
    private final with_index<X> origin;

    public mapped_with_index(BiFunction<X, Integer, Y> mapper, possible<X> origin) {
        this(mapper, new with_index<>(origin));
    }

    public mapped_with_index(BiFunction<X, Integer, Y> mapper, with_index<X> origin) {
        this.mapper = mapper;
        this.origin = origin;
    }

    @Override
    public void supply(Consumer<? super Y> consumer) {
        origin.supply((x, i) -> consumer.accept(mapper.apply(x, i)));
    }
}
