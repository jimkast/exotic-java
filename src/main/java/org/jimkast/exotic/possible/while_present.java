package org.jimkast.exotic.possible;

import org.jimkast.exotic.bool.cond_loop;
import org.jimkast.exotic.possible.util.FlagConsumer;
import org.jimkast.exotic.possible.util.pmapping;

public final class while_present<T> extends possible.env<T> {
    public while_present(possible<T> origin) {
        this(origin, new FlagConsumer<>(1));
    }

    public while_present(possible<T> origin, FlagConsumer<T> incomplete) {
        super(new pmapping<>(consumer -> {
            return new cond_loop(
                incomplete,
                () -> {
                    incomplete.reset();
                    origin.supply(incomplete.andThen(consumer));
                }
            );
        }));
    }
}
