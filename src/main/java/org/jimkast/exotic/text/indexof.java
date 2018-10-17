package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.binary.blength;
import org.jimkast.exotic.number.sub;
import org.jimkast.exotic.numberjdk.NumberEnvelope;
import org.jimkast.exotic.possible.orelse;
import org.jimkast.exotic.possible.range;
import org.jimkast.exotic.possible.filtered;

public final class indexof extends NumberEnvelope {
    public indexof(binary source, binary target) {
        super(
            new orelse<>(
                new filtered<>(
                    i -> new starts_with(new skipped(i, source), target),
                    new range(0, new sub(new blength(source), new blength(target)))
                ), -1
            )
        );
    }
}
