package org.jimkast.exotic.possible.gen;

import org.jimkast.exotic.bool.lt;
import org.jimkast.exotic.possible.possible;
import org.jimkast.exotic.possible.gen_until;

public final class fori extends possible.env<Number> {
    public fori(int to) {
        this(0, to);
    }

    public fori(int from, int to) {
        this(from, to, 1);
    }

    public fori(int from, int to, int step) {
        super(
            new gen_until<>(
                o -> new lt(o, to),
                new seq_arithmetic(from, step)
            )
        );
    }
}
