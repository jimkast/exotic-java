package org.jimkast.ooj.target;

import org.jimkast.ooj.cond.Cond;
import org.jimkast.ooj.lang.Quantity;
import org.jimkast.ooj.source.Store;
import org.jimkast.ooj.source.Target;

public final class Stack<T> implements Store<T>, Quantity {
    private final ObjectArray<T> arr;
    private int count = 0;
    private int next = 0;

    public Stack(int size) {
        this(new ObjectArray.Native<>(size));
    }

    public Stack(ObjectArray<T> arr) {
        this.arr = arr;
    }

    @Override
    public Cond feed(Target<T> target) {
        if (count == 0) {
            return Cond.FALSE;
        }
        count--;
        int len = arr.length();
        next = (next + len - 1) % len;
        return arr.map(next).feed(target);
    }

    @Override
    public void accept(T t) {
        int len = arr.length();
        arr.accept(next, t);
        next = (next + 1) % len;
        if (count < len) {
            count++;
        }
    }

    @Override
    public int length() {
        return count;
    }
}