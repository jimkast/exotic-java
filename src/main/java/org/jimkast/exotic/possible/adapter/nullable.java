package org.jimkast.exotic.possible.adapter;

import java.util.function.Consumer;
import org.jimkast.exotic.possible.possible;

public final class nullable<T> implements possible<T> {
    private final T nullable;

    public nullable(T nullable) {
        this.nullable = nullable;
    }

    @Override
    public void supply(Consumer<? super T> consumer) {
        if (nullable != null) {
            consumer.accept(nullable);
        }
//            new isnull(nullable).choose(t -> {}, consumer).accept(nullable);
    }
}
