package org.jimkast.ooj.map.iterable;

import java.util.Collections;
import java.util.Iterator;
import java.util.function.Predicate;
import org.jimkast.ooj.map.Mapping;

public final class Case<K, V> implements Mapping<K, Iterator<V>> {
    private final Predicate<K> check;
    private final Iterator<V> value;

    public Case(Predicate<K> check, V value) {
        this(check, new IterFixed<>(value));
    }

    Case(Predicate<K> check, Iterator<V> value) {
        this.check = check;
        this.value = value;
    }

    @Override
    public Iterator<V> map(K key) {
        return check.test(key) ? value : Collections.emptyIterator();
    }
}
