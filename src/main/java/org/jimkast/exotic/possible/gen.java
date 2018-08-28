package org.jimkast.exotic.possible;

import java.util.LinkedList;
import java.util.Queue;
import org.cactoos.Func;
import org.cactoos.Scalar;
import org.jimkast.exotic.bool.bool;

public final class gen<T> implements Scalar<T> {
    private final T start;
    private final Func<T, T> next;
    private final transient Queue<T> store = new LinkedList<>();

    public gen(T start, Func<T, T> next) {
        this.start = start;
        this.next = next;
    }

    @Override
    public T value() throws Exception {
        return new bool.ofbool(store.isEmpty()).choose((Scalar<T>) () -> {
            store.add(start);
            return start;
        }, () -> {
            store.add(next.apply(store.poll()));
            return store.element();
        }).value();
    }
}
