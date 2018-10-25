package org.jimkast.ooj.source;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import org.jimkast.ooj.cond.Cond;

public final class StoreQueue<T> implements Store<T>, Iterator<T> {
    private final Queue<T> queue;

    public StoreQueue() {
        this(new LinkedList<>());
    }

    public StoreQueue(Queue<T> queue) {
        this.queue = queue;
    }

    @Override
    public void accept(T t) {
        queue.add(t);
    }

    @Override
    public Cond feed(Target<T> target) {
        if (queue.isEmpty()) {
            return Cond.FALSE;
        }
        target.accept(queue.poll());
        return Cond.TRUE;
    }

    @Override
    public boolean hasNext() {
        return queue.isEmpty();
    }

    @Override
    public T next() {
        return queue.poll();
    }
}
