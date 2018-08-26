package org.jimkast.exotic.possible;

import java.util.function.Consumer;

public final class while_present<T> implements possible<T> {
    private final possible<T> factory;

    public while_present(possible<T> factory) {
        this.factory = factory;
    }

    @Override
    public void ifPresent(Consumer<T> consumer) {
        factory.ifPresent(consumer.andThen(t -> ifPresent(consumer)));
    }
}
