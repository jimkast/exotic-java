package org.jimkast.ooj.target;

import org.jimkast.exotic.map.Mapping;
import org.jimkast.ooj.bisource.BiTarget;
import org.jimkast.ooj.lang.Quantity;

public interface ObjectArray<T> extends Mapping<Integer, T>, BiTarget<Integer, T>, Quantity {
    @Override
    T map(Integer i);

    @Override
    void accept(Integer i, T t);

    @Override
    int length();


    final class Native<T> implements ObjectArray<T> {
        private final T[] arr;

        @SuppressWarnings("unchecked")
        public Native(int size) {
            this((T[]) new Object[size]);
        }

        @SafeVarargs
        public Native(T... arr) {
            this.arr = arr;
        }

        @Override
        public T map(Integer i) {
            return arr[i];
        }

        @Override
        public void accept(Integer i, T t) {
            arr[i] = t;
        }

        @Override
        public int length() {
            return arr.length;
        }
    }
}
