package org.jimkast.ooj.map;

import org.jimkast.ooj.cond.Check;

public final class MappingFork<K, T> implements Mapping<K, T> {
    private final Check<K> check;
    private final Mapping<K, T> main;
    private final Mapping<K, T> other;

    public MappingFork(Check<K> check, Mapping<K, T> main, Mapping<K, T> other) {
        this.check = check;
        this.main = main;
        this.other = other;
    }

    @Override
    public T map(K key) {
        return check.test(key).choose(main, other).map(key);
    }
}
