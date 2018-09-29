package org.jimkast.exotic.text;

public final class trimmed_right implements binary {
    private final binary origin;
    private final byte32 spaces;

    public trimmed_right(binary origin) {
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
    public int at(int i) {
        return origin.at(i);
    }

    @Override
    public int length() {
        return origin.length() - spaces.value();
    }
}
