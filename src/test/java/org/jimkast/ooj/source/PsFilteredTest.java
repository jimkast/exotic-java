package org.jimkast.ooj.source;

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
}