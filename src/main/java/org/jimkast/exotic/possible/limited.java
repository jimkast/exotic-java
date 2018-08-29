package org.jimkast.exotic.possible;

import org.jimkast.exotic.bool.lte;
import org.jimkast.exotic.possible.index.until_with_index;

public final class limited<T> extends possible.env<T> {
    public limited(Number max, possible<T> origin) {
        super(new until_with_index<>(
            (t, i) -> new lte(i, max),
            origin
        ));
    }
}
