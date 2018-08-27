package org.jimkast.exotic.possible;

import java.util.function.Consumer;
import org.jimkast.exotic.bool.lte;

public final class limited<T> implements possible<T>, Consumer<T> {
    private final Number max;
    private final possible<T> origin;
    private int i = 0;

    public limited(Number max, possible<T> origin) {
        this.max = max;
        this.origin = origin;
    }

    @Override
    public void supply(Consumer<? super T> consumer) {
        origin.supply(t -> new lte(i, max).choose(this.andThen(consumer), t1 -> {
        }).accept(t));
    }

    @Override
    public void accept(T t) {
        i++;
    }
}
