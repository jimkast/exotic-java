package org.jimkast.exotic.binary;

import org.jimkast.exotic.bool.bool;
import org.jimkast.exotic.bool.gte;

public final class bigger extends bool.env {
    public bigger(binary container, binary part) {
        super(new gte(
            new blength(container),
            new blength(part)
        ));
    }
}
