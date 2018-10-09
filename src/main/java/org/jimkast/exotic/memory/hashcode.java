package org.jimkast.exotic.memory;

import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.numberjdk.NumberEnvelope;
import org.jimkast.exotic.possible.reduced;

public final class hashcode extends NumberEnvelope {
    public hashcode(binary b) {
        super(
            new reduced<>(
                0,
                (h, v) -> 31 * h + v,
                new binary.values(b)
            )
        );
    }
}
