package org.jimkast.exotic.possible.index;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.jimkast.exotic.possible.possible;

public interface windex<T> {
    void supply(BiConsumer<? super T, Integer> consumer);

    final class asppossible<T> implements possible<T> {
        private final windex<T> origin;

        public asppossible(windex<T> origin) {
            this.origin = origin;
        }

        @Override
        public void supply(Consumer<? super T> consumer) {
            origin.supply((t, i) -> consumer.accept(t));
        }
    }
}
