package org.jimkast.exotic.number.types;

public interface array<T> {
    T get(int i);

    int length();

//    public static final class merged<T> implements array<T> {
//        private final possible<array<T>> all;
//
//
//        @Override
//        public T get(int i) {
//            return new first<array<T>>(
//                o -> o.length() >= i,
//                all
//            );
//        }
//
//        @Override
//        public int length() {
//            return 0;
//        }
//    }
}
