package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.bool.bool;
import org.jimkast.exotic.eq;

public final class eq_casei extends bool.env {
    public eq_casei(binary t1, binary t2) {
        super(new eq(new uppercase(t1), new uppercase(t2)));
    }
}
