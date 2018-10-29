package org.jimkast.ooj.lang;

public interface Array<T> extends IntMapping<T>, Quantity {

    Array<?> EMPTY = new Empty<>();

    final class Range implements Array<Integer> {
        private final int size;

        public Range(int size) {
            this.size = size;
        }

        @Override
        public Integer map(int offset) {
            return offset;
        }

        @Override
        public int length() {
            return size;
        }
    }

    final class Empty<T> implements Array<T> {
        @Override
        public T map(int offset) {
            throw new IndexOutOfBoundsException();
        }

        @Override
        public int length() {
            return 0;
        }

        public static <T> Array<T> instance() {
            return (Array<T>) EMPTY;
        }
    }
}
