package org.jimkast.ooj.lang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public interface Store<T> extends Target<T>, Scalar<T> {

    final class StoreList<T> implements Store<T> {
        private final List<T> list;

        public StoreList() {
            this(new ArrayList<>(1));
        }

        public StoreList(List<T> list) {
            this.list = list;
        }

        @Override
        public T value() {
            return list.get(0);
        }

        @Override
        public void accept(T t) {
            if (list.isEmpty()) {
                list.add(t);
            } else {
                list.set(0, t);
            }
        }
    }

    final class StoreQueue<T> implements Store<T> {
        private final Queue<T> queue;

        public StoreQueue() {
            this(new LinkedList<>());
        }

        public StoreQueue(Queue<T> queue) {
            this.queue = queue;
        }

        @Override
        public T value() {
            return queue.poll();
        }

        @Override
        public void accept(T t) {
            queue.add(t);
        }
    }
}