package org.jimkast.ooj.target;

import org.jimkast.ooj.lang.ArrayEditable;

public interface ObjectArray<T> extends ArrayEditable<T> {

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
        public T map(int i) {
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
