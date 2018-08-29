package org.jimkast.exotic.possible;

import java.util.function.Consumer;
import org.jimkast.exotic.bool.check;

public final class until<T> implements possible<T> {
    private final check<T> check;
    private final possible<T> origin;

    public until(check<T> check, possible<T> origin) {
        this.check = check;
        this.origin = origin;
    }

    @Override
    public void supply(Consumer<? super T> consumer) {
        origin.supply(t -> check.test(t).choose(consumer, o -> {}).accept(t));
    }
}
