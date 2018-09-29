package org.jimkast.exotic.util;

import java.util.ArrayList;
import java.util.List;

public final class sticky<T> implements scalar<T> {
    private final scalar<T> origin;
    private final List<T> val = new ArrayList<>(1);

    public sticky(scalar<T> origin) {
        this.origin = origin;
    }

    @Override
    public T value() {
        if (val.isEmpty()) {
            val.add(origin.value());
        }
        return val.get(0);
    }
}
