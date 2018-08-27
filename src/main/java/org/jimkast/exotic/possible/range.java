package org.jimkast.exotic.possible;

import org.jimkast.exotic.bool.lte;

public final class range extends possible.env<Integer> {
    public range(int to) {
        this(0, to);
    }

    public range(int from, int to) {
        this(from, to, 1);
    }

    public range(int from, int to, int step) {
        super(
            new generated<>(
                o -> new lte(o, to),
                new gen<>(from, i -> i + step)
            )
        );
    }
}
