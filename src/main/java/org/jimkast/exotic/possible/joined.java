package org.jimkast.exotic.possible;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;
import org.jimkast.exotic.bool.bool;
import org.jimkast.exotic.possible.adapter.iterable;

public final class joined<T> implements possible<T> {
    private final possible<possible<T>> possibles;
    private final transient Queue<possible<T>> store = new LinkedList<>();
    private final transient possible<possible<T>> used = new possible.fixed<>(store::poll);
    private final transient possible<T> empty = new possible.empty<>();

    @SafeVarargs
    public joined(possible<T>... possibles) {
        this(new iterable<>(possibles));
    }

    public joined(possible<possible<T>> possibles) {
        this.possibles = possibles;
    }

    @Override
    public void supply(Consumer<? super T> consumer) {
        new bool.ofbool(store.isEmpty()).choose(possibles, used).supply(p -> {
            p.supply(t -> {
                store.add(p);
                consumer.accept(t);
            });
            if (store.isEmpty()) {
                supply(consumer);
            }
//            new bool.ofbool(store.isEmpty()).choose(this, empty).supply(consumer);
        });
    }
}
