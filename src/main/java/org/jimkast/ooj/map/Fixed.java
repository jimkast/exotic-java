package org.jimkast.ooj.map;

import org.jimkast.ooj.lang.Mapping;
import org.jimkast.ooj.lang.PSource;

public final class Fixed<K, V> extends PMapping.Env<K, V> {
    public Fixed(V value) {
        super(new OfMapping<>(new Mapping.Fixed<>(new PSource.Fixed<>(value))));
    }
}
