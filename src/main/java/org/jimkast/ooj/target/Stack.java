package org.jimkast.ooj.target;

import org.jimkast.ooj.lang.ArrayTarget;
import org.jimkast.ooj.source.Store;
import org.jimkast.ooj.source.Target;

public final class Stack<T> implements Store<T>, ArrayTarget<T> {
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
    public void feed(Target<T> target) {
        if (count > 0) {
            count--;
            int len = arr.length();
            next = (next + len - 1) % len;
            target.accept(arr.map(next));
        }
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

    @Override
    public T map(int offset) {
        int len = arr.length();
        return arr.map((next + len - offset) % len);
    }
}
