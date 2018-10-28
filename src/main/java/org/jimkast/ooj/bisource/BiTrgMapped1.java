package org.jimkast.ooj.bisource;

import org.jimkast.ooj.map.BiMapping;

public final class BiTrgMapped1<X, Y, Z> implements BiTarget<X, Y> {
    private final BiMapping<X, Y, Z> mapping;
    private final BiTarget<Z, Y> origin;

    public BiTrgMapped1(BiMapping<X, Y, Z> mapping, BiTarget<Z, Y> origin) {
        this.mapping = mapping;
        this.origin = origin;
    }

    @Override
    public void accept(X x, Y y) {
        origin.accept(mapping.map(x, y), y);
    }
}
