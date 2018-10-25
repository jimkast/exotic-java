package org.jimkast.ooj.source;

import java.util.ArrayList;
import java.util.List;
import org.jimkast.ooj.cond.Cond;

public final class StoreList<T> implements Store<T> {
    private final List<T> list;

    public StoreList() {
        this(new ArrayList<>(1));
    }

    public StoreList(List<T> list) {
        this.list = list;
    }

    @Override
    public void accept(T t) {
        if (list.isEmpty()) {
            list.add(t);
        } else {
            list.set(0, t);
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
