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
        Cond result = Cond.ADAPTER.map(iterator.hasNext());
        result.choose(target, Target.Noop.<T>instance()).accept(iterator.next());
        return result;
    }
}
