package org.jimkast.exotic.possible;

import java.util.function.Consumer;

public final class nullable<T> implements possible<T> {
    private final T nullable;

    public nullable(T nullable) {
        this.nullable = nullable;
    }

    @Override
    public void ifPresent(Consumer<? super T> consumer) {
        if (nullable != null) {
            consumer.accept(nullable);
        }
//            new isnull(nullable).choose(t -> {}, consumer).accept(nullable);
    }
}
