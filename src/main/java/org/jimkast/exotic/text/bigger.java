package org.jimkast.exotic.text;

import org.jimkast.exotic.bool.bool;
import org.jimkast.exotic.bool.gte;

public final class bigger extends bool.env {
    public bigger(text container, text part) {
        super(new gte(
            new text.length(container),
            new text.length(part)
        ));
    }
}
