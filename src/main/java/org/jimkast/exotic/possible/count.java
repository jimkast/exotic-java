package org.jimkast.exotic.possible;

import org.jimkast.exotic.numberjdk.NumberEnvelope;
import org.jimkast.exotic.possible.index.mapped_with_index;

public final class count extends NumberEnvelope {
    public count(possible<?> p) {
        super(new orelse<>(new last<>(new mapped_with_index<>((o, i) -> i, p)), 0));
    }
}
