package org.jimkast.exotic;

import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.binary.blength;
import org.jimkast.exotic.bool.both;
import org.jimkast.exotic.bool.bool;
import org.jimkast.exotic.possible.all;

public final class eq extends bool.env {
    public eq(binary t1, binary t2) {
        super(
            new both(
                new org.jimkast.exotic.bool.eq(new blength(t1), new blength(t1)),
                new all<>(
                    i -> new org.jimkast.exotic.bool.eq(t1.map(i), t2.map(i)),
                    new binary.indices(t1)
                )
            )
        );
    }
}
