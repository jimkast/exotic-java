package org.jimkast.exotic.text;

import org.jimkast.exotic.bool.and;
import org.jimkast.exotic.bool.bool;
import org.jimkast.exotic.bool.eq;
import org.jimkast.exotic.possible.all;

public final class starts_with extends bool.env {
    public starts_with(text container, text part) {
        super(
            new and(
                new bigger(container, part),
                new all<>(
                    i -> new eq(container.at(i), part.at(i)),
                    new text.indexes(part)
                )
            )
        );
    }
}
