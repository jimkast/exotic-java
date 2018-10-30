package org.jimkast.ooj.lang;

public interface IntArray extends IntIntMapping, Quantity {

    IntArray EMPTY = new Empty();


    final class Range implements IntArray {
        private final int size;

        public Range(int size) {
            this.size = size;
        }

        @Override
        public int map(int offset) {
            return offset;
        }

        @Override
        public int length() {
            return size;
        }
    }


    final class Empty implements IntArray {
        @Override
        public int map(int offset) {
            throw new IndexOutOfBoundsException();
        }

        @Override
        public int length() {
            return 0;
        }
    }
}
