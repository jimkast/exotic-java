package org.jimkast.exotic.possible;

import java.util.function.Consumer;
import org.jimkast.exotic.bool.check;

public final class skip_until<T> implements possible<T> {
    private final check<T> check;
    private final possible<T> origin;

    public skip_until(check<T> check, possible<T> origin) {
        this.check = check;
        this.origin = origin;
    }

    @Override
    public void supply(Consumer<? super T> consumer) {

//        int[] flag = new int[]{0};
//        while (flag[0] == 0) {
//            origin.supply(t -> check.test(t).choose(consumer, x -> flag[0] = 1));
//        }
        origin.supply(new CondConsumer<>(check, consumer, new Recursive<>(this, consumer)));
//        origin.supply(t -> check.test(t).choose(consumer, t1 -> supply(consumer)).accept(t));
    }


    public static final class Recursive<T> implements Consumer<T> {
        private final possible<T> p;
        private final Consumer<? super T> consumer;

        public Recursive(possible<T> p, Consumer<? super T> consumer) {
            this.p = p;
            this.consumer = consumer;
        }

        @Override
        public void accept(T t) {
            p.supply(consumer);
        }
    }


    public static final class CondConsumer<T> implements Consumer<T> {
        private final check<T> check;
        private final Consumer<? super T> c1;
        private final Consumer<? super T> c2;

        public CondConsumer(check<T> check, Consumer<? super T> c1, Consumer<? super T> c2) {
            this.check = check;
            this.c1 = c1;
            this.c2 = c2;
        }

        @Override
        public void accept(T t) {
            check.test(t).<Consumer<? super T>>choose(c1, c2).accept(t);
        }
    }

}
