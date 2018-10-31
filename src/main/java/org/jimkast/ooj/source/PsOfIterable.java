package org.jimkast.ooj.source;

import java.util.Arrays;
import java.util.Iterator;

public final class PsOfIterable<T> implements Source<T> {
    private final Iterable<T> items;

    @SafeVarargs
    public PsOfIterable(T... items) {
        this(Arrays.asList(items));
    }

    public PsOfIterable(Iterable<T> items) {
        this.items = items;
    }

    @Override
    public void feed(Target<T> target) {
        Iterator<T> iter = items.iterator();
        if (iter.hasNext()) {
            target.accept(iter.next());
        }
    }
}
