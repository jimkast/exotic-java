package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.binary.blength;
import org.jimkast.exotic.numberjdk.IntSticky;

public final class cached_length implements binary {
    private final binary b;
    private final Number len;

    public cached_length(binary b) {
        this(b, new IntSticky(new blength(b)));
    }

    private cached_length(binary b, Number len) {
        this.b = b;
        this.len = len;
    }

    @Override
    public int at(int i) {
        return b.at(i);
    }

    @Override
    public int length() {
        return len.intValue();
    }
}
