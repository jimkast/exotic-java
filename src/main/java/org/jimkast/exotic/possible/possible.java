package org.jimkast.exotic.possible;

import java.util.function.Consumer;
import org.cactoos.Scalar;
import org.cactoos.scalar.UncheckedScalar;

public interface possible<T> {
    void ifPresent(Consumer<T> consumer);


    class env<T> implements possible<T> {
        private final possible<T> origin;

        public env(possible<T> origin) {
            this.origin = origin;
        }

        @Override
        public final void ifPresent(Consumer<T> consumer) {
            origin.ifPresent(consumer);
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
        public void ifPresent(Consumer<T> consumer) {
            consumer.accept(val.value());
        }
    }


    final class empty<T> implements possible<T> {
        @Override
        public void ifPresent(Consumer<T> consumer) {
        }
    }


}
