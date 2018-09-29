package org.jimkast.exotic.text;

import org.jimkast.exotic.number.sub;
import org.jimkast.exotic.numberjdk.NumberEnvelope;
import org.jimkast.exotic.possible.orelse;
import org.jimkast.exotic.possible.range;
import org.jimkast.exotic.possible.skip_until;

public final class indexof extends NumberEnvelope {
    public indexof(text source, text target) {
        super(
            new orelse<>(
                new skip_until<>(
                    i -> new starts_with(new substring(source, i), target),
                    new range(0, new sub(new text.length(source), new text.length(target)))
                ), -1
            )
        );
    }
}
