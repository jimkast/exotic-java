package org.jimkast.ooj.target;

import org.jimkast.ooj.lang.ArrayTarget;
import org.jimkast.ooj.source.Store;
import org.jimkast.ooj.source.Target;

public final class Queue<T> implements Store<T>, ArrayTarget<T> {
    private final ObjectArray<T> arr;
    private int count;
    private int next;

    public Queue(int size) {
        this(new ObjectArray.Native<>(size));
    }

    @SafeVarargs
    public Queue(T... items) {
        this(0, items);
    }

    @SafeVarargs
    public Queue(int count, T... items) {
        this(count, new ObjectArray.Native<>(items));
    }

    public Queue(ObjectArray<T> arr) {
        this(0, arr);
    }

    public Queue(int count, ObjectArray<T> arr) {
        this.arr = arr;
        this.count = count;
        this.next = count;
    }

    @Override
    public void feed(Target<T> target) {
        if (count > 0) {
            count--;
            int len = arr.length();
            target.accept(arr.map((next + len - count - 1) % len));
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
        return arr.map((next + len - count - 1 + offset) % len);
    }
}
