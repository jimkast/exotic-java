package org.jimkast.ooj.map;

import org.jimkast.ooj.cond.Check;
import org.jimkast.ooj.source.Source;

public final class Case<K, V> extends PMapping.Env<K, V> {
    public Case(Check<K> check, V value) {
        super(new OfMapping<>(new MappingCond<>(check, new Source.Fixed<>(value), Source.Empty.instance())));
    }
}
