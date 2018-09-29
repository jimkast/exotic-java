package org.jimkast.exotic.text;

import org.jimkast.exotic.bool.bool;

public final class ends_with implements bool {
    private final text container;
    private final text part;

    public ends_with(text container, text part) {
        this.container = container;
        this.part = part;
    }

    @Override
    public <T> T choose(T left, T right) {
        int len = part.length();
        for (int i = len - 1; i >= 0; i--) {
            if (container.at(i) != part.at(i)) {
                return right;
            }
        }
        return left;
    }
}
