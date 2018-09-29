package org.jimkast.exotic.text;

import org.jimkast.exotic.bool.eq;
import org.jimkast.exotic.numberjdk.NumberEnvelope;
import org.jimkast.exotic.possible.orelse;
import org.jimkast.exotic.possible.skip_until;

public final class chindex extends NumberEnvelope {
    public chindex(binary t1, char ch) {
        super(
            new orelse<>(
                new skip_until<>(
                    i -> new eq(t1.at(i), ch),
                    new binary.indices(t1)
                ), -1
            )
        );
    }
}
