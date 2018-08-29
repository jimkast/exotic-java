package org.jimkast.exotic.possible;

import org.jimkast.exotic.bool.lte;
import org.jimkast.exotic.numberjdk.as_int;
import org.jimkast.exotic.possible.gen.seq_arithmetic;

public final class range extends possible.env<Integer> {
    public range(Number to) {
        this(1, to);
    }

    public range(Number from, Number to) {
        this(from, to, 1);
    }

    public range(Number from, Number to, Number step) {
        super(
            new until<>(
                o -> new lte(o, to),
                new as_int(
                    new seq_arithmetic(from, step)
                )
            )
        );
    }
}
