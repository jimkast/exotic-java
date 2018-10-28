package org.jimkast.ooj.bisource;

import org.jimkast.ooj.map.BiMapping;

public final class BiTrgMapped2<X, Y, Z> implements BiTarget<X, Y> {
    private final BiMapping<X, Y, Z> mapping;
    private final BiTarget<X, Z> origin;

    public BiTrgMapped2(BiMapping<X, Y, Z> mapping, BiTarget<X, Z> origin) {
        this.mapping = mapping;
        this.origin = origin;
    }

    @Override
    public void accept(X x, Y y) {
        origin.accept(x, mapping.map(x, y));
    }
}
