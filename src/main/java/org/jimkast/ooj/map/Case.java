package org.jimkast.ooj.map;

import org.jimkast.ooj.lang.Check;
import org.jimkast.ooj.lang.PSource;

public final class Case<K, V> extends PMapping.Env<K, V> {
    public Case(Check<K> check, V value) {
        super(new OfMapping<>(new MappingCond<>(check, new PSource.Fixed<>(value), PSource.Empty.instance())));
    }
}
