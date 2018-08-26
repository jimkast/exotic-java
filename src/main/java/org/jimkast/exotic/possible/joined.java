package org.jimkast.exotic.possible;

import java.util.function.Consumer;

public final class joined<T> implements possible<T> {
    private final possible<possible<T>> possibles;

    @SafeVarargs
    public joined(possible<T>... possibles) {
        this(new iterable<>(possibles));
    }

    public joined(possible<possible<T>> possibles) {
        this.possibles = possibles;
    }

    @Override
    public void ifPresent(Consumer<T> consumer) {
        possibles.ifPresent(p -> p.ifPresent(consumer.andThen(t -> ifPresent(consumer))));
    }
}
