package org.jimkast.exotic.possible;

import java.util.function.Consumer;
import java.util.function.Function;
import org.jimkast.exotic.bool.and;
import org.jimkast.exotic.bool.bool;
import org.jimkast.exotic.bool.check;
import org.jimkast.exotic.bool.cond_loop;
import org.jimkast.exotic.bool.not;
import org.jimkast.exotic.possible.util.CondConsumer;
import org.jimkast.exotic.possible.util.FlagConsumer;

public final class skip_until<T> implements possible<T> {
    private final Function<Consumer<? super T>, Runnable> mapping;

    public skip_until(check<T> check, possible<T> origin) {
        this(check, origin, new FlagConsumer<>(), new FlagConsumer<>(1));
    }

    private skip_until(check<T> check, possible<T> origin, FlagConsumer<T> found, FlagConsumer<T> incomplete) {
        this(check, origin, found, incomplete, new and(new not(found), incomplete));
    }

    private skip_until(check<T> check, possible<T> origin, FlagConsumer<T> found, FlagConsumer<T> incomplete, bool cond) {
        this(consumer -> {
            found.reset();
            return new cond_loop(
                cond,
                () -> {
                    incomplete.reset();
                    origin.supply(new CondConsumer<>(check, incomplete.andThen(found).andThen(consumer), incomplete));
                }
            );
        });
    }

    private skip_until(Function<Consumer<? super T>, Runnable> mapping) {
        this.mapping = mapping;
    }

    @Override
    public void supply(Consumer<? super T> consumer) {
        mapping.apply(consumer).run();
    }
}
