package org.jimkast.exotic.possible.gens;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.cactoos.Func;
import org.cactoos.Scalar;

public final class gen<T> implements Scalar<T> {
    private final Func<List<T>, T> gen;
    private final List<T> store;

    @SafeVarargs
    public gen(Func<List<T>, T> gen, T... items) {
        this(gen, new FifoQueue<>(items.length, new LinkedList<>(Arrays.asList(items))));
    }

    public gen(Func<List<T>, T> gen, List<T> store) {
        this.gen = gen;
        this.store = store;
    }

    @Override
    public T value() throws Exception {
        T cur = store.get(0);
        store.add(gen.apply(store));
        return cur;
    }
}
