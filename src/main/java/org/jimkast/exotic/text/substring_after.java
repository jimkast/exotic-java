package org.jimkast.exotic.text;

import org.jimkast.exotic.number.add;
import org.jimkast.exotic.numberjdk.Int;

public final class substring_after extends text.env {
    public substring_after(text origin, text after) {
        super(new substring(origin, new add(new indexof(origin, after), new Int() {
            @Override
            public int intValue() {
                return after.length();
            }
        })));
    }
}
