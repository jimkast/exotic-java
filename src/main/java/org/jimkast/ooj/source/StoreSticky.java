package org.jimkast.ooj.source;

import java.util.ArrayList;
import java.util.List;
import org.jimkast.ooj.lang.Cond;
import org.jimkast.ooj.lang.Mapping;
import org.jimkast.ooj.lang.Store;
import org.jimkast.ooj.lang.Target;

public final class StoreSticky<T> implements Mapping<T, T>, Store<T> {
    private final List<T> list;

    public StoreSticky() {
        this(new ArrayList<>(1));
    }

    public StoreSticky(List<T> list) {
        this.list = list;
    }

    @Override
    public T map(T t) {
        if (list.isEmpty()) {
            list.add(t);
        }
        return list.get(0);
    }

    @Override
    public T value() {
        return list.get(0);
    }

    @Override
    public void accept(T t) {
        if (list.isEmpty()) {
            list.add(t);
        }
    }

    @Override
    public Cond feed(Target<T> target) {
        if (list.isEmpty()) {
            return Cond.FALSE;
        }
        target.accept(list.get(0));
        return Cond.TRUE;
    }
}
