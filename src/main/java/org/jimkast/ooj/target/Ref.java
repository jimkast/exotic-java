package org.jimkast.ooj.target;

import org.jimkast.ooj.lang.ArrayTarget;
import org.jimkast.ooj.source.Store;
import org.jimkast.ooj.source.Target;

public final class Ref<T> implements Store<T>, ArrayTarget<T> {
    private T ref;

    public Ref() {
    }

    public Ref(T ref) {
        this.ref = ref;
    }

    @Override
    public void feed(Target<T> target) {
        if (ref != null) {
            target.accept(ref);
        }
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
