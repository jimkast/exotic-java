package org.jimkast.ooj.target;

import org.jimkast.exotic.map.Mapping;
import org.jimkast.ooj.bisource.BiTarget;
import org.jimkast.ooj.lang.Quantity;
import org.jimkast.ooj.source.PSource;

public interface ObjectArray<T> extends Mapping<Integer, PSource<T>>, BiTarget<Integer, T>, Quantity {
    @Override
    PSource<T> map(Integer i);

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
        public PSource<T> map(Integer i) {
            T val = arr[i];
            return val == null ? PSource.Empty.instance() : new PSource.Fixed<>(val);
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
