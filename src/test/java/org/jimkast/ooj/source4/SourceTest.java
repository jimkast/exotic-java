package org.jimkast.ooj.source4;

import org.jimkast.ooj.cond.Cond;
import org.junit.Test;
import static org.junit.Assert.*;

public class SourceTest {

    @Test
    public void feed() {
        new Source.ForEach<>(
            new Source.Filtered<>(
                i -> i < 10 || i > 90 ? Cond.TRUE : Cond.FALSE,
                new Source.Range<>(
                    1, 10
                )
            )
        ).feed(System.out::println);
    }
}