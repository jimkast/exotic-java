package org.jimkast.ooj.source4;

import org.jimkast.ooj.map.BiMapping;

public final class Reduced<T> implements BiSource<T, T> {
    private final Source<T> origin;

    public Reduced(Source<T> origin) {
        this.origin = origin;
    }

    @Override
    public <Z> Z feed(BiMapping<T, T, Z> target, Z other) {
        return null;
    }
}
