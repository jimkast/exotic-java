package org.jimkast.exotic.possible;

import java.util.Iterator;
import java.util.function.Consumer;

public final class iterator<T> implements possible<T> {
    private final Iterator<T> iterator;

    public iterator(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    @Override
    public void ifPresent(Consumer<? super T> consumer) {
        if (iterator.hasNext()) {
            consumer.accept(iterator.next());
        }
    }
}
