package org.jimkast.ooj.target;

import org.jimkast.ooj.cond.Cond;
import org.jimkast.ooj.lang.Array;
import org.jimkast.ooj.source.Store;
import org.jimkast.ooj.source.Target;

public final class Ref<T> implements Store<T>, Array<T> {
    private T ref;

    public Ref() {
    }

    public Ref(T ref) {
        this.ref = ref;
    }

    @Override
    public Cond feed(Target<T> target) {
        if (ref == null) {
            return Cond.FALSE;
        }
        target.accept(ref);
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
