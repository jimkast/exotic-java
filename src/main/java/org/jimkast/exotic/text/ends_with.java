package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.bigger;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.bool.both;
import org.jimkast.exotic.bool.bool;
import org.jimkast.exotic.bool.eq;
import org.jimkast.exotic.possible.all;

public final class ends_with extends bool.env {
    public ends_with(binary container, binary part) {
        super(
            new both(
                new bigger(container, part),
                new all<>(
                    i -> new eq(container.at(container.length() - i), part.at(part.length() - i)),
                    new binary.indices(part)
                )
            )
        );
    }
}
