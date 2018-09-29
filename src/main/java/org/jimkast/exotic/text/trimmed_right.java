package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.numberjdk.Int;

public final class trimmed_right implements binary {
    private final binary origin;
    private final Number spaces;

    public trimmed_right(binary origin) {
        this(origin, new Int() {
            @Override
            public int intValue() {
                int len = origin.length();
                int k = 0;
                while (k < len && Character.isWhitespace(origin.at(len - k))) {
                    k++;
                }
                return len - k;
            }
        });
    }

    private trimmed_right(binary origin, Number spaces) {
        this.origin = origin;
        this.spaces = spaces;
    }

    @Override
    public int at(int i) {
        return origin.at(i);
    }

    @Override
    public int length() {
        return origin.length() - spaces.intValue();
    }
}
