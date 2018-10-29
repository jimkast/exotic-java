package org.jimkast.exotic.binary;

import org.jimkast.exotic.numberjdk.Int;

public final class smaller_index_of extends Int {
    private final binary b;

    public smaller_index_of(binary b) {
        this.b = b;
    }

    @Override
    public int intValue() {
        int min = Integer.MAX_VALUE;
        int index = -1;
        int len = b.length();
        for (int i = 0; i < len; i++) {
            int val = b.map(i);
            if (b.map(i) < min) {
                min = val;
                index = i;
            }
        }
        return index;
    }
}
