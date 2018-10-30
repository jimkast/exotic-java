package org.jimkast.ooj.source;

import java.util.Arrays;
import java.util.Iterator;

public final class PsOfIterator<T> implements Source<T> {
    private final Iterator<T> iterator;

    @SafeVarargs
    public PsOfIterator(T... items) {
        this(Arrays.asList(items).iterator());
    }

    public PsOfIterator(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    @Override
    public void feed(Target<T> target) {
        if (iterator.hasNext()) {
            target.accept(iterator.next());
        }
    }
}
