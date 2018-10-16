package org.jimkast.exotic.possible;

import java.util.function.Consumer;
import java.util.function.Function;
import org.jimkast.exotic.bool.cond_loop;
import org.jimkast.exotic.possible.util.FlagConsumer;

public final class while_present<T> implements possible<T> {
    private final Function<Consumer<? super T>, Runnable> mapping;

    public while_present(possible<T> origin) {
        this(origin, new FlagConsumer<>(1));
    }

    public while_present(possible<T> origin, FlagConsumer<T> incomplete) {
        this(consumer -> {
            return new cond_loop(
                incomplete,
                () -> {
                    incomplete.reset();
                    origin.supply(incomplete.andThen(consumer));
                }
            );
        });
    }

    public while_present(Function<Consumer<? super T>, Runnable> mapping) {
        this.mapping = mapping;
    }

    @Override
    public void supply(Consumer<? super T> consumer) {
        mapping.apply(consumer).run();
    }


    public static final class RunCount<T> implements Consumer<T> {
        private final Consumer<T> c;
        private int count = 0;

        public RunCount(Consumer<T> c) {
            this.c = c;
        }

        @Override
        public void accept(T t) {
            c.accept(t);
            count++;
        }
    }
}
