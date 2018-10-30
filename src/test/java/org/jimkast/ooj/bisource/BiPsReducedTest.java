package org.jimkast.ooj.bisource;

import org.jimkast.ooj.source.PsForEach;
import org.jimkast.ooj.source.PsRange;
import org.junit.Test;

public class BiPsReducedTest {

    @Test
    public void feed() {
        new PsForEach<>(
            new PsReduced<>(
                0,
                (i, i2) -> i*i,
                new PsRange(1, 10)
            )
        ).feed(System.out::println);
    }
}