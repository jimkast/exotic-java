package org.jimkast.ooj.source;

import java.util.Iterator;
import org.jimkast.ooj.lang.Cond;
import org.jimkast.ooj.lang.PSource;
import org.jimkast.ooj.lang.Target;

public final class PsOfIterator<T> implements PSource<T> {
    private final Iterator<T> iterator;

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
