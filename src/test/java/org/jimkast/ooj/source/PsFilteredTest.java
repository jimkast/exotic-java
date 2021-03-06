package org.jimkast.ooj.source;

import java.util.Arrays;
import org.jimkast.ooj.cond.Cond;
import org.junit.Test;

public class PsFilteredTest {

    @Test
    public void setUp() throws Exception {
        new PsForEach<>(
            new PsFiltered<>(
                i -> i > 5 && i < 12 || i > 17 ? Cond.TRUE : Cond.FALSE,
                new PsRange(20)
            )
        ).feed(System.out::println);
    }

    @Test
    public void setUp2222() throws Exception {
        new PsForEach<>(
            new PsFiltered2<>(
                i -> i > 5 && i < 12 || i > 17 ? Cond.TRUE : Cond.FALSE,
                new PsRange(20)
            )
        ).feed(System.out::println);
    }


    @Test
    public void setUp2() throws Exception {
        new PsForEach<>(new PsRange(20)).feed(System.out::println);
    }

    @Test
    public void all() throws Exception {
        Source<Integer> p = new PsFlattenedSingle<>(
            new PsRange(1, 10),
            new PsRange(11, 20),
            new PsRange(21, 30)
        );
        p.feed(System.out::println);
        p.feed(System.out::println);
        p.feed(System.out::println);
        p.feed(System.out::println);

        new PsForEach<>(p).feed(System.out::println);
    }


    @Test
    public void iterator() throws Exception {
        new PsForEach<>(
            new PsOfIterator<>(
                Arrays.asList(1, 4, 6, 8, 9, 2).iterator()
            )
        ).feed(System.out::println);
    }
}