package org.jimkast.ooj.bisource;

import org.jimkast.ooj.source.PsForEach;
import org.jimkast.ooj.source.PsRange;
import org.junit.Test;
import static org.junit.Assert.*;

public class BiPsReducedTest {

    @Test
    public void feed() {
        new PsForEach<>(
            new BiPsReduced<>(
                0,
                (i, i2) -> i + i2,
                new PsRange(1, 10)
            )
        ).feed(System.out::println);
    }
}