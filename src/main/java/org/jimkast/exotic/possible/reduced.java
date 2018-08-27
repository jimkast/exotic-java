package org.jimkast.exotic.possible;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.BiFunction;
import org.cactoos.Scalar;

public final class reduced<X, Y> implements Scalar<Y> {
    private final Y initial;
    private final BiFunction<X, Y, Y> accumulator;
    private final possible<X> origin;

    public reduced(Y initial, BiFunction<X, Y, Y> accumulator, possible<X> origin) {
        this.initial = initial;
        this.accumulator = accumulator;
        this.origin = origin;
    }

    @Override
    public Y value() {
        Queue<Y> store = new LinkedList<>();
        store.add(initial);
        origin.supply(t -> store.add(accumulator.apply(t, store.poll())));
        return store.poll();
    }
}
