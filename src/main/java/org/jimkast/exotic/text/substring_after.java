package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.binary.blength;
import org.jimkast.exotic.number.add;

public final class substring_after extends binary.env {
    public substring_after(binary origin, binary after) {
        super(new skipped(origin, new add(new indexof(origin, after), new blength(after))));
    }
}
