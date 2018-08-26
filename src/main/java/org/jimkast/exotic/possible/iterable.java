package org.jimkast.exotic.possible;

import java.util.Arrays;
import java.util.function.Consumer;

public final class iterable<T> implements possible<T> {
    private final Iterable<T> iterable;

    @SafeVarargs
    public iterable(T... items) {
        this(Arrays.asList(items));
    }

    public iterable(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    @Override
    public void ifPresent(Consumer<? super T> consumer) {
        new while_present<>(
            new iterator<>(
                iterable.iterator()
            )
        ).ifPresent(consumer);
    }
}
