package org.jimkast.exotic.possible;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public final class with_index<T> implements possible<T> {
    private final possible<T> origin;
    private int i = 0;


    public with_index(possible<T> origin) {
        this.origin = origin;
    }

    @Override
    public void ifPresent(Consumer<T> consumer) {
        origin.ifPresent(consumer);
    }

    public void foreach(BiConsumer<T, Integer> consumer) {
        origin.ifPresent(t -> consumer.accept(t, i));
    }
}
