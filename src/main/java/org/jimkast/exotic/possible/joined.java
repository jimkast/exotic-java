package org.jimkast.exotic.possible;

import java.util.function.Consumer;
import org.jimkast.exotic.possible.adapter.iterable;

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
    public void supply(Consumer<? super T> consumer) {
        possibles.supply(p -> p.supply(consumer));
    }
}
