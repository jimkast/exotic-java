package org.jimkast.exotic.possible;

import org.cactoos.iterable.StickyIterable;
import org.jimkast.exotic.possible.adapter.AsIterable;
import org.jimkast.exotic.possible.adapter.iterable;

public final class sticky<T> extends possible.env<T> {
    public sticky(possible<T> origin) {
        super(
            new iterable<>(
                new StickyIterable<>(
                    new AsIterable<>(origin)
                )
            )
        );
    }
}
