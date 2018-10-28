package org.jimkast.ooj.target;

import org.jimkast.ooj.cond.Cond;
import org.jimkast.ooj.lang.ArrayTarget;
import org.jimkast.ooj.source.Store;
import org.jimkast.ooj.source.Target;

public final class RefQueue<T> implements Store<T>, ArrayTarget<T> {
    private T ref;

    public RefQueue() {
    }

    public RefQueue(T ref) {
        this.ref = ref;
    }

    @Override
    public Cond feed(Target<T> target) {
        if (ref == null) {
            return Cond.FALSE;
        }
        target.accept(ref);
        ref = null;
        return Cond.TRUE;
    }

    @Override
    public void accept(T t) {
        ref = t;
    }

    @Override
    public int length() {
        return ref == null ? 0 : 1;
    }

    @Override
    public T map(int offset) {
        if (offset != 0 || ref == null) {
            throw new IndexOutOfBoundsException("For offset " + offset);
        }
        return ref;
    }
}
