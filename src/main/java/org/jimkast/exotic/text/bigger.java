package org.jimkast.exotic.text;

import org.jimkast.exotic.bool.bool;
import org.jimkast.exotic.bool.gte;

public final class bigger extends bool.env {
    public bigger(binary container, binary part) {
        super(new gte(
            new binary.length(container),
            new binary.length(part)
        ));
    }
}
