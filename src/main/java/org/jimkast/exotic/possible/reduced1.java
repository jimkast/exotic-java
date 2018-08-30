package org.jimkast.exotic.possible;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

public final class reduced1<T> extends possible.env<T> {
    public reduced1(BiFunction<T, T, T> accumulator, possible<T> origin) {
        this(new ArrayList<>(1), accumulator, origin);
    }

    public reduced1(T initial, BiFunction<T, T, T> accumulator, possible<T> origin) {
        this(new ArrayList<>(Collections.singletonList(initial)), accumulator, origin);
    }

    public reduced1(List<T> initial, BiFunction<T, T, T> accumulator, possible<T> origin) {
        super(new mapped<>(
            t -> {
                initial.add(0, initial.isEmpty() ? t : accumulator.apply(initial.get(0), t));
                return initial.get(0);
            },
            origin
        ));
    }
}
