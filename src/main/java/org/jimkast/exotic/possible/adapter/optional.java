package org.jimkast.exotic.possible.adapter;

import java.util.Optional;
import java.util.function.Consumer;
import org.jimkast.exotic.possible.possible;

public final class optional<T> implements possible<T> {
    private final Optional<T> optional;

    public optional(Optional<T> optional) {
        this.optional = optional;
    }

    @Override
    public void supply(Consumer<? super T> consumer) {
        optional.ifPresent(consumer);
    }
}
