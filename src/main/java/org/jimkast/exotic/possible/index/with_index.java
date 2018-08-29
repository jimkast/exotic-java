package org.jimkast.exotic.possible.index;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.jimkast.exotic.possible.possible;

public final class with_index<T> implements windex<T>, possible<T> {
    private final possible<T> origin;
    private int i = 1;


    public with_index(possible<T> origin) {
        this.origin = origin;
    }

    @Override
    public void supply(Consumer<? super T> consumer) {
        origin.supply(consumer);
    }

    @Override
    public void supply(BiConsumer<? super T, Integer> consumer) {
        origin.supply(t -> consumer.accept(t, i++));
    }
}
