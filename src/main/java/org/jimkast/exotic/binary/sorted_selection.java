package org.jimkast.exotic.binary;

import org.jimkast.exotic.possible.mapped;
import org.jimkast.exotic.possible.possible;
import org.jimkast.exotic.text.skipped;

public final class sorted_selection extends possible.env<Integer> {
    public sorted_selection(binary origin) {
        super(new mapped<>(
            i -> new smaller_index_of(new skipped(i, origin)).intValue(),
            new binary.indices(origin)
        ));
    }
}
