package org.jimkast.exotic.possible.gens;

import org.jimkast.exotic.bool.lte;
import org.jimkast.exotic.possible.possible;
import org.jimkast.exotic.possible.until;

public final class fori extends possible.env<Integer> {
    public fori(int to) {
        this(0, to);
    }

    public fori(int from, int to) {
        this(from, to, 1);
    }

    public fori(int from, int to, int step) {
        super(
            new until<>(
                o -> new lte(o, to),
                new integers(from, step)
            )
        );
    }
}
