package org.jimkast.ooj.source4;

import org.jimkast.ooj.cond.Cond;
import org.junit.Test;

public class SourceTest {

    @Test
    public void feed() {
        new Source.ForEach<>(
            new Source.Mapped<>(
                key -> "Hi " + key,
                new Source.Filtered<>(
                    i -> i < 3 || i > 7 ? Cond.TRUE : Cond.FALSE,
                    new Source.Range<>(
                        1, 10
                    )
                )
            )
        ).feed(System.out::println);
    }
}