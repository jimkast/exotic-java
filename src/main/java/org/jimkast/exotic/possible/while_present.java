package org.jimkast.exotic.possible;

import java.util.function.Consumer;

public final class while_present<T> implements possible<T> {
    private final possible<T> origin;
    private final int[] f = new int[]{0};

    public while_present(possible<T> origin) {
        this.origin = origin;
    }

    @Override
    public void supply(Consumer<? super T> consumer) {
//        RunCount<? super T> count = new RunCount<>(consumer);
//        new cond_loop(
//            new eq(f[0], 0),
//            () -> {
//                f[0] = 1;
//                origin.supply(t -> {
//                    f[0] = 0;
//                    consumer.accept(t);
//                });
//            }
//        ).run();
        int[] flag = new int[]{0};
        while (flag[0] == 0) {
            flag[0] = 1;
            origin.supply(t -> {
                flag[0] = 0;
                consumer.accept(t);
            });
        }
//        origin.supply(t -> {
//            consumer.accept(t);
//            supply(consumer);
//        });
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
