package org.jimkast.exotic.possible;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface possible2<T1, T2> {
    void supply(BiConsumer<? super T1, ? super T2> consumer);


    class env<T1, T2> implements possible2<T1, T2> {
        private final possible2<T1, T2> origin;

        public env(possible2<T1, T2> origin) {
            this.origin = origin;
        }

        @Override
        public final void supply(BiConsumer<? super T1, ? super T2> consumer) {
            origin.supply(consumer);
        }
    }

    final class as_single<T1, T2> implements possible<T1> {
        private final possible2<T1, T2> origin;

        public as_single(possible2<T1, T2> origin) {
            this.origin = origin;
        }

        @Override
        public void supply(Consumer<? super T1> consumer) {
            origin.supply((t1, t2) -> consumer.accept(t1));
        }
    }
}
