package org.jimkast.exotic.possible;

import java.util.function.Consumer;
import org.cactoos.Scalar;
import org.cactoos.scalar.UncheckedScalar;

public interface possible<T> {
    void supply(Consumer<? super T> consumer);

    possible<?> EMPTY = new empty<>();

    class env<T> implements possible<T> {
        private final possible<T> origin;

        public env(possible<T> origin) {
            this.origin = origin;
        }

        @Override
        public final void supply(Consumer<? super T> consumer) {
            origin.supply(consumer);
        }
    }


    final class fixed<T> implements possible<T> {
        private final UncheckedScalar<T> val;

        public fixed(T val) {
            this(() -> val);
        }

        public fixed(Scalar<T> val) {
            this(new UncheckedScalar<>(val));
        }

        public fixed(UncheckedScalar<T> val) {
            this.val = val;
        }

        @Override
        public void supply(Consumer<? super T> consumer) {
            consumer.accept(val.value());
        }
    }


    final class empty<T> implements possible<T> {
        @Override
        public void supply(Consumer<? super T> consumer) {
        }

        @SuppressWarnings("unchecked")
        public static <T> possible<T> instance() {
            return (possible<T>) EMPTY;
        }

    }


}
