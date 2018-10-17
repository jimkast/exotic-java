package org.jimkast.exotic.possible;

import org.jimkast.exotic.bool.bool;
import org.jimkast.exotic.bool.both;
import org.jimkast.exotic.bool.check;
import org.jimkast.exotic.bool.cond_loop;
import org.jimkast.exotic.bool.not;
import org.jimkast.exotic.possible.util.CondConsumer;
import org.jimkast.exotic.possible.util.FlagConsumer;
import org.jimkast.exotic.possible.util.pmapping;

public final class filtered<T> extends possible.env<T> {
    public filtered(check<T> check, possible<T> origin) {
        this(check, origin, new FlagConsumer<>(), new FlagConsumer<>(1));
    }

    private filtered(check<T> check, possible<T> origin, FlagConsumer<T> found, FlagConsumer<T> incomplete) {
        this(check, origin, found, incomplete, new both(new not(found), incomplete));
    }

    private filtered(check<T> check, possible<T> origin, FlagConsumer<T> found, FlagConsumer<T> incomplete, bool cond) {
        super(new pmapping<>(consumer -> {
            found.reset();
            return new cond_loop(
                cond,
                () -> {
                    incomplete.reset();
                    origin.supply(new CondConsumer<>(check, incomplete.andThen(found).andThen(consumer), incomplete));
                }
            );
        }));
    }
}
