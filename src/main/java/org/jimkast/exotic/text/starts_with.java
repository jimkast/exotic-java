package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.bigger;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.bool.both;
import org.jimkast.exotic.bool.bool;
import org.jimkast.exotic.bool.eq;
import org.jimkast.exotic.possible.all;

public final class starts_with extends bool.env {
    public starts_with(binary container, binary part) {
        super(
            new both(
                new bigger(container, part),
                new all<>(
                    i -> new eq(container.at(i), part.at(i)),
                    new binary.indices(part)
                )
            )
        );
    }
}
