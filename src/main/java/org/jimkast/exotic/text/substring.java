package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;

public final class substring extends binary.env {
    public substring(binary origin, Number offset, Number len) {
        super(new headof(new skipped(origin, offset), len));
    }
}
