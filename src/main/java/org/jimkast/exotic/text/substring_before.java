package org.jimkast.exotic.text;

public final class substring_before extends text.env {
    public substring_before(text origin, text after) {
        super(new substring(origin, 0, new indexof(origin, after)));
    }
}
