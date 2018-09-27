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
        int[] flag = new int[]{0};
        while (flag[0] == 0) {
            origin.supply(t -> check.test(t).choose(consumer, x -> flag[0] = 1));
        }
//        origin.supply(t -> check.test(t).choose(consumer, t1 -> supply(consumer)).accept(t));
    }
}
