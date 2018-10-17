package org.jimkast.exotic.possible.util;

import java.util.function.Consumer;
import java.util.function.Function;
import org.jimkast.exotic.possible.possible;

public final class pmapping<T> implements possible<T> {
    private final Function<Consumer<? super T>, Runnable> mapping;

    public pmapping(Function<Consumer<? super T>, Runnable> mapping) {
        this.mapping = mapping;
    }

    @Override
    public void supply(Consumer<? super T> consumer) {
        mapping.apply(consumer).run();
    }
}
