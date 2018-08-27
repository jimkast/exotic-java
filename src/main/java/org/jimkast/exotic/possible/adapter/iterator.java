package org.jimkast.exotic.possible.adapter;

import java.util.Iterator;
import java.util.function.Consumer;
import org.jimkast.exotic.possible.possible;

public final class iterator<T> implements possible<T> {
    private final Iterator<T> iterator;

    public iterator(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    @Override
    public void supply(Consumer<? super T> consumer) {
        if (iterator.hasNext()) {
            consumer.accept(iterator.next());
        }
    }
}
