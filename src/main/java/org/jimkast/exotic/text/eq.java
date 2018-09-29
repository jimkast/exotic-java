package org.jimkast.exotic.text;

import org.jimkast.exotic.bool.and;
import org.jimkast.exotic.bool.bool;
import org.jimkast.exotic.possible.all;

public final class eq extends bool.env {
    public eq(text t1, text t2) {
        super(
            new and(
                new org.jimkast.exotic.bool.eq(new text.length(t1), new text.length(t1)),
                new all<>(
                    i -> new org.jimkast.exotic.bool.eq(t1.at(i), t1.at(i)),
                    new text.indices(t1)
                )
            )
        );
    }
}
