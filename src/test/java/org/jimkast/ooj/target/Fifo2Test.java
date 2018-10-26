package org.jimkast.ooj.target;

import org.jimkast.ooj.source.PsForEach;
import org.jimkast.ooj.source.PsRange;
import org.jimkast.ooj.source.Store;
import org.junit.Test;

public class Fifo2Test {
    @Test
    public void filo() throws Exception {
        Store<Integer> queue = new Stack<>(4);
        queue.feed(System.out::println);
        new PsForEach<>(new PsRange(1, 25)).feed(queue);
        new PsForEach<>(queue).feed(System.out::println);
    }

    @Test
    public void fifo() throws Exception {
        Store<Integer> queue = new Queue<>(4);
        queue.feed(System.out::println);
        new PsForEach<>(new PsRange(1, 25)).feed(queue);
        new PsForEach<>(queue).feed(System.out::println);
    }
}