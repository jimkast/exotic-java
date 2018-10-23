package org.jimkast.ooj.source;

import java.util.Arrays;
import org.jimkast.ooj.lang.Cond;
import org.junit.Test;

public class PsFilteredTest {

    @Test
    public void setUp() throws Exception {
        new PsForAll<>(
            new PsFiltered<>(
                i -> i > 5 && i < 12 || i > 17 ? Cond.TRUE : Cond.FALSE,
                new PsRange(20)
            )
        ).feed(System.out::println);
    }


    @Test
    public void setUp2() throws Exception {
        new PsForAll<>(new PsRange(20)).feed(System.out::println);
    }

    @Test
    public void all() throws Exception {
        PsAll<Integer> p = new PsAll<>(
            new PsRange(1, 10),
            new PsRange(11, 20),
            new PsRange(21, 30)
        );
        p.feed(System.out::println);
        p.feed(System.out::println);
        p.feed(System.out::println);
        p.feed(System.out::println);

        new PsForAll<>(p).feed(System.out::println);
    }


    @Test
    public void iterator() throws Exception {
        new PsForAll<>(
            new PsOfIterator<>(
                Arrays.asList(1, 4, 6, 8, 9, 2).iterator()
            )
        ).feed(System.out::println);
    }
}