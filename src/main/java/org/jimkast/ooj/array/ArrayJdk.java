package org.jimkast.ooj.array;

import java.util.List;
import org.jimkast.ooj.lang.ArrayEditable;
import org.jimkast.ooj.lang.ArrayTarget;

public final class ArrayJdk<T> implements ArrayTarget<T>, ArrayEditable<T> {
    private final List<T> list;

    public ArrayJdk(List<T> list) {
        this.list = list;
    }

    @Override
    public void accept(Integer i, T t) {
        list.add(i, t);
    }

    @Override
    public T map(int offset) {
        return list.get(offset);
    }

    @Override
    public int length() {
        return list.size();
    }

    @Override
    public void accept(T t) {
        list.add(t);
    }
}
