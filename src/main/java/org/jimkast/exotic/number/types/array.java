package org.jimkast.exotic.number.types;

import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import org.jimkast.exotic.Native;
import org.jimkast.exotic.possible.possible;
import org.jimkast.exotic.possible.while_present;

public interface array<T> {
    T item(int i);

    int length();


    class env<T> implements array<T> {
        private final array<T> origin;

        public env(array<T> origin) {
            this.origin = origin;
        }

        @Override
        public final T item(int i) {
            return origin.item(i);
        }

        @Override
        public final int length() {
            return origin.length();
        }
    }


    @Native
    final class malloc<T> implements array<T> {
        private final T[] arr;

        @SafeVarargs
        public malloc(T... arr) {
            this.arr = arr;
        }

        @Override
        public T item(int i) {
            return arr[i];
        }

        @Override
        public int length() {
            return arr.length;
        }

        public void put(int i, T item) {
            arr[i] = item;
        }
    }


    final class oflist<T> implements array<T> {
        private final List<T> list;

        public oflist(List<T> list) {
            this.list = list;
        }

        @Override
        public T item(int i) {
            return list.get(i);
        }

        @Override
        public int length() {
            return list.size();
        }
    }


    final class merged<T> implements array<T> {
        private final possible<array<T>> all;
        private final NavigableMap<Integer, array<T>> index = new TreeMap<>();

        public merged(possible<array<T>> all) {
            this.all = all;
        }

        @Override
        public T item(int i) {
            Map.Entry<Integer, array<T>> entry = index().floorEntry(i);
            return entry.getValue().item(i - entry.getKey());
        }

        @Override
        public int length() {
            return index().lastKey();
        }

        private NavigableMap<Integer, array<T>> index() {
            if (index.isEmpty()) {
                new while_present<>(all).supply(arr -> index.put(arr.length(), arr));
            }
            return index;
        }
    }
//
//    final class merged2<T> implements array<T> {
//        private final possible<array<T>> all;
//        private final possible<Number> sizes;
//
//        public merged2(possible<array<T>> all) {
//            this.all = all;
//            this.sizes = new subs(new mapped<>(array::length, all));
//        }
//
//        @Override
//        public T item(int i) {
//            new combined2<>(all, sizes).supply((tarray, number) -> );
//            new count(new until<>(o -> o.intValue() , sizes)
//            Map.Entry<Integer, array<T>> entry = index().floorEntry(i);
//            return entry.getValue().item(i - entry.getKey());
//        }
//
//        @Override
//        public int length() {
//            return index().lastKey();
//        }
//
//        private NavigableMap<Integer, array<T>> index() {
//            if (index.isEmpty()) {
//                new while_present<>(all).supply(arr -> index.put(arr.length(), arr));
//            }
//            return index;
//        }
//    }
}
