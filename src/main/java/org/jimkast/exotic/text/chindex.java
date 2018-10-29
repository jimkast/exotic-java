package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.bool.eq;
import org.jimkast.exotic.numberjdk.NumberEnvelope;
import org.jimkast.exotic.possible.orelse;
import org.jimkast.exotic.possible.filtered;

public final class chindex extends NumberEnvelope {
    public chindex(binary t1, char ch) {
        super(
            new orelse<>(
                new filtered<>(
                    i -> new eq(t1.map(i), ch),
                    new binary.indices(t1)
                ), -1
            )
        );
    }
}
