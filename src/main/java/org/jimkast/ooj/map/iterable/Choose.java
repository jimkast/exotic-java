package org.jimkast.ooj.map.iterable;

import java.util.Arrays;
import java.util.Iterator;
import org.jimkast.ooj.map.Mapping;

public final class Choose<K, V> implements Mapping<K, V> {
    private final V def;
    private final Iterable<Mapping<K, Iterator<V>>> all;

    @SafeVarargs
    public Choose(V def, Mapping<K, Iterator<V>>... all) {
        this(def, Arrays.asList(all));
    }

    public Choose(V def, Iterable<Mapping<K, Iterator<V>>> all) {
        this.def = def;
        this.all = all;
    }

    @Override
    public V map(K key) {
        for (Mapping<K, Iterator<V>> mapping : all) {
            Iterator<V> iter = mapping.map(key);
            if (iter.hasNext()) {
                return iter.next();
            }
        }
        return def;
    }
}
