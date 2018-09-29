package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;

public final class substring_before extends binary.env {
    public substring_before(binary origin, binary after) {
        super(new headof(origin, new indexof(origin, after)));
    }
}
