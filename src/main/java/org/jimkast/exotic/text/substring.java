package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;

public final class substring extends binary.env {
    public substring(Number offset, Number len, binary origin) {
        super(new headof(len, new skipped(offset, origin)));
    }
}
