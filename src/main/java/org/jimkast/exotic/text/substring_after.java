package org.jimkast.exotic.text;

import org.jimkast.exotic.number.add;

public final class substring_after extends binary.env {
    public substring_after(binary origin, binary after) {
        super(new substring(origin, new add(new indexof(origin, after), new binary.length(after))));
    }
}
