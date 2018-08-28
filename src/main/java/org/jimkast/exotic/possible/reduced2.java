package org.jimkast.exotic.possible;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public final class reduced2<T> implements possible<T> {
    private final List<T> initial = new ArrayList<>(1);
    private final possible<T> p;

    public reduced2(BiFunction<T, T, T> accumulator, possible<T> origin) {
        this.p = new mapped<>(
            t -> {
                initial.add(0, initial.isEmpty() ? t : accumulator.apply(initial.get(0), t));
                return initial.get(0);
            },
            origin
        );
    }

    @Override
    public void supply(Consumer<? super T> consumer) {
        p.supply(consumer);
    }
}
