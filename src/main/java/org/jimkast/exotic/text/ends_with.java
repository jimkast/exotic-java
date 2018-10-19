package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.bigger;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.binary.blength;
import org.jimkast.exotic.bool.bool;
import org.jimkast.exotic.bool.both;
import org.jimkast.exotic.bool.eq;
import org.jimkast.exotic.numberjdk.NumSticky;
import org.jimkast.exotic.possible.all;

public final class ends_with extends bool.env {
    public ends_with(binary container, binary part) {
        this(container, part, new NumSticky(new blength(container)), new NumSticky(new blength(part)));
    }

    private ends_with(binary container, binary part, Number clen, Number plen) {
        super(
            new both(
                new bigger(container, part),
                new all<>(
                    i -> new eq(container.at(clen.intValue() - i), part.at(plen.intValue() - i)),
                    new binary.indices(part)
                )
            )
        );
    }
}
