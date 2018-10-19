package org.jimkast.exotic.binary;

import org.jimkast.exotic.numberjdk.Int;

public final class blength extends Int {
    private final binary b;

    public blength(binary b) {
        this.b = b;
    }

    @Override
    public int intValue() {
        return b.length();
    }
}
