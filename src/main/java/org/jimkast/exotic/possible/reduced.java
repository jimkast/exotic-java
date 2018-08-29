package org.jimkast.exotic.possible;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.BiFunction;
import org.cactoos.Scalar;

public final class reduced<X, Y> implements Scalar<Y> {
    private final Y initial;
    private final BiFunction<Y, X, Y> accumulator;
    private final possible<X> origin;

    public reduced(Y initial, BiFunction<Y, X, Y> accumulator, possible<X> origin) {
        this.initial = initial;
        this.accumulator = accumulator;
        this.origin = origin;
//        List<Y> store = new ArrayList<>(Collections.singletonList(initial));
//        possible<Y> o = new mapped<X, Y>(
//            o1 -> {
//                store.set(0, accumulator.apply(store.get(0), o1));
//                return store.get(0);
//            },
//            origin
//        );
    }

    @Override
    public Y value() {
        Queue<Y> store = new LinkedList<>();
        store.add(initial);
        origin.supply(t -> store.add(accumulator.apply(store.poll(), t)));
        return store.poll();
    }
}
