package org.jimkast.ooj.target;

import org.jimkast.ooj.cond.Cond;
import org.jimkast.ooj.source.Target;

public final class Ref<T> implements StoreCountable<T> {
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
}
