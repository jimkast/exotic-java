package org.jimkast.exotic.text;

public final class substring_after extends text.env {
    public substring_after(text origin, text after) {
        super(new substring(origin, new indexof(origin, after)));
    }
}
