package org.jimkast.exotic.possible.gen;

import org.jimkast.exotic.bool.neq;
import org.jimkast.exotic.number.mod;
import org.jimkast.exotic.numberjdk.NumberEnvelope;
import org.jimkast.exotic.possible.last;
import org.jimkast.exotic.possible.orelse;
import org.jimkast.exotic.possible.pwhile;

public final class GCD extends NumberEnvelope {
    public GCD(Number p, Number q) {
        super(
            new orelse<>(
                new last<>(
                    new pwhile<>(
                        o -> new neq(o, 0),
                        new gen2<>(p, q, mod::new)
                    )
                ), -1
            )
        );
    }
}
