package org.jimkast.exotic.possible;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;

public final class of<T> extends possible.env<T> {
    @SafeVarargs
    public of(T... items) {
        this(Arrays.asList(items));
    }

    public of(Iterator<T> iterator) {
        this(new iterator<>(iterator));
    }

    public of(Iterable<T> iterable) {
        this(new iterable<>(iterable));
    }

    public of(Optional<T> optional) {
        this(new optional<>(optional));
    }

    public of(possible<T> origin) {
        super(origin);
    }
}
