package org.jimkast.ooj.source;

import java.util.Arrays;
import java.util.Iterator;
import org.jimkast.ooj.cond.Cond;

public final class PsOfIterator<T> implements PSource<T> {
    private final Iterator<T> iterator;

    @SafeVarargs
    public PsOfIterator(T... items) {
        this(Arrays.asList(items).iterator());
    }

    public PsOfIterator(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    @Override
    public Cond feed(Target<T> target) {
        if(!iterator.hasNext()) {
            return Cond.FALSE;
        }
        target.accept(iterator.next());
        return Cond.TRUE;
    }
}
