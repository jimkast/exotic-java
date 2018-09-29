package org.jimkast.exotic.text;

import org.jimkast.exotic.bool.and;
import org.jimkast.exotic.bool.bool;
import org.jimkast.exotic.bool.eq;
import org.jimkast.exotic.possible.all;

public final class ends_with extends bool.env {
    public ends_with(text container, text part) {
        super(
            new and(
                new bigger(container, part),
                new all<>(
                    i -> new eq(container.at(container.length() - i), part.at(part.length() - i)),
                    new text.indices(part)
                )
            )
        );
    }
}
