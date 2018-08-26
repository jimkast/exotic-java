package org.jimkast.exotic.possible;

import java.util.Optional;
import java.util.function.Consumer;

public final class optional<T> implements possible<T> {
    private final Optional<T> optional;

    public optional(Optional<T> optional) {
        this.optional = optional;
    }

    @Override
    public void ifPresent(Consumer<? super T> consumer) {
        optional.ifPresent(consumer);
    }
}
