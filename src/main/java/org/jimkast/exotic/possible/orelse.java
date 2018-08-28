package org.jimkast.exotic.possible;

import java.util.LinkedList;
import java.util.Queue;
import org.cactoos.Scalar;

public final class orelse<T> implements Scalar<T> {
    private final possible<T> possible;
    private final Scalar<T> other;

    public orelse(possible<T> possible, T other) {
        this(possible, () -> other);
    }

    public orelse(possible<T> possible, Scalar<T> other) {
        this.possible = possible;
        this.other = other;
    }

    @Override
    public T value() throws Exception {
        Queue<T> store = new LinkedList<>();
        possible.supply(store::add);
        return store.isEmpty() ? other.value() : store.poll();
    }
}
