package org.jimkast.exotic.text;

public final class substring_before extends binary.env {
    public substring_before(binary origin, binary after) {
        super(new substring(origin, 0, new indexof(origin, after)));
    }
}
