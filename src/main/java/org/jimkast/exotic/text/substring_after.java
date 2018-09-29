package org.jimkast.exotic.text;

import org.jimkast.exotic.number.add;

public final class substring_after extends text.env {
    public substring_after(text origin, text after) {
        super(new substring(origin, new add(new indexof(origin, after), new text.length(after))));
    }
}
