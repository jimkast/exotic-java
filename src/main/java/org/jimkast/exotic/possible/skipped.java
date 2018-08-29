package org.jimkast.exotic.possible;

import org.jimkast.exotic.bool.lte;
import org.jimkast.exotic.possible.index.skip_until_with_index;

public final class skipped<T> extends possible.env<T> {
    public skipped(Number total, possible<T> origin) {
        super(new skip_until_with_index<>(
            (o, i) -> new lte(i, total),
            origin
        ));
    }
}
