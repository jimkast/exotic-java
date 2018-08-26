package org.jimkast.exotic.possible;

import org.jimkast.exotic.bool.lt;

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
                from,
                o -> new lt(o, to),
                number -> number + step
            )
        );
    }
}
