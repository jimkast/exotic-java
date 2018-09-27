package org.jimkast.exotic.possible;

import java.util.function.Consumer;

public final class while_present<T> implements possible<T> {
    private final possible<T> origin;

    public while_present(possible<T> origin) {
        this.origin = origin;
    }

    @Override
    public void supply(Consumer<? super T> consumer) {
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
}
