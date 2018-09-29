package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;

public final class trimmed extends binary.env {
    public trimmed(binary origin) {
        super(new trimmed_right(new trimmed_left(origin)));
    }
}
