package org.jimkast.exotic.text;

public final class trimmed_left implements binary {
    private final binary origin;
    private final byte32 spaces;

    public trimmed_left(binary origin) {
        this(origin, () -> {
            int len = origin.length();
            int k = 0;
            while (k < len && Character.isWhitespace(origin.at(k))) {
                k++;
            }
            return len - k;
        });
    }

    private trimmed_left(binary origin, byte32 spaces) {
        this.origin = origin;
        this.spaces = spaces;
    }

    @Override
    public int at(int i) {
        return origin.at(i + spaces.value());
    }

    @Override
    public int length() {
        return origin.length() - spaces.value();
    }
}
