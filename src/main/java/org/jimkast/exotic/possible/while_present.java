package org.jimkast.exotic.possible;

import java.util.function.Consumer;
import java.util.function.Function;
import org.jimkast.exotic.bool.cond_loop;
import org.jimkast.exotic.possible.util.FlagConsumer;
import org.jimkast.exotic.possible.util.pmapping;

public final class while_present<T> extends possible.env<T> {
    public while_present(possible<T> origin) {
        this(origin, new FlagConsumer<>(1));
    }

    public while_present(possible<T> origin, FlagConsumer<T> incomplete) {
        super(new pmapping<>(new WhileMapping<>(incomplete, origin)));
    }


    public static final class WhileMapping<T> implements Function<Consumer<? super T>, Runnable> {
        private final FlagConsumer<T> incomplete;
        private final possible<T> origin;

        public WhileMapping(FlagConsumer<T> incomplete, possible<T> origin) {
            this.incomplete = incomplete;
            this.origin = origin;
        }

        @Override
        public Runnable apply(Consumer<? super T> consumer) {
            return new cond_loop(incomplete, new WhileRunnable<>(incomplete, consumer, origin));
        }
    }


    public static final class WhileRunnable<T> implements Runnable {
        private final FlagConsumer<T> incomplete;
        private final Consumer<? super T> consumer;
        private final possible<T> origin;

        public WhileRunnable(FlagConsumer<T> incomplete, Consumer<? super T> consumer, possible<T> origin) {
            this.incomplete = incomplete;
            this.consumer = consumer;
            this.origin = origin;
        }

        @Override
        public void run() {
            incomplete.reset();
            origin.supply(incomplete.andThen(consumer));
        }
    }
}
