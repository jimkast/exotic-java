package org.jimkast.exotic.text;

import java.util.function.IntSupplier;

public final class trimmed_right implements text {
    private final text origin;
    private final IntSupplier spaces;

    public trimmed_right(text origin) {
        this.origin = origin;
        this.spaces = () -> {
            int len = origin.length();
            int k = 0;
            while (k < len && Character.isWhitespace(origin.at(len - k))) {
                k++;
            }
            return len - k;
        };
    }


    @Override
    public char at(int i) {
        return origin.at(i);
    }

    @Override
    public int length() {
        return origin.length() - spaces.getAsInt();
    }
}
