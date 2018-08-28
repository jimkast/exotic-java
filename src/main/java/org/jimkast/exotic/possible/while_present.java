package org.jimkast.exotic.possible;

import java.util.function.Consumer;

public final class while_present<T> implements possible<T> {
    private final possible<T> origin;

    public while_present(possible<T> origin) {
        this.origin = origin;
    }

    @Override
    public void supply(Consumer<? super T> consumer) {
        origin.supply(t -> {
            consumer.accept(t);
            supply(consumer);
        });
    }
}
