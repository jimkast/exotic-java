package org.jimkast.ooj.map;

import org.jimkast.ooj.lang.Check;
import org.jimkast.ooj.lang.Mapping;

public final class MappingCond<K, T> implements Mapping<K, T> {
    private final Check<K> check;
    private final T main;
    private final T other;

    public MappingCond(Check<K> check, T main, T other) {
        this.check = check;
        this.main = main;
        this.other = other;
    }

    @Override
    public T map(K key) {
        return check.test(key).choose(main, other);
    }
}
