package org.jimkast.ooj.source;

import java.util.Iterator;
import org.jimkast.ooj.cond.Cond;

public final class Store1Simple<T> implements Store<T>, Iterator<T> {
    private static final Integer ZERO = 0;
    private final Object[] mem = new Object[]{ZERO};

    @Override
    public void accept(T t) {
        mem[0] = t;
    }

    @Override
    public Cond feed(Target<T> target) {
        if (hasNext()) {
            return Cond.FALSE;
        }
        target.accept(next());
        return Cond.TRUE;
    }

    @Override
    public boolean hasNext() {
        return ZERO.equals(mem[0]);
    }

    @Override
    public T next() {
        T temp = (T) mem[0];
        mem[0] = ZERO;
        return temp;
    }
}
