package org.jimkast.ooj.dict;

import java.util.LinkedList;
import java.util.List;
import org.jimkast.ooj.lang.Dictionary;
import org.jimkast.ooj.lang.PSource;
import org.jimkast.ooj.source.PsOfIterator;

public final class DictLinear<K, V> implements Dictionary<K, V> {
    private final V def;
    private final List<K> keys;
    private final List<V> values;

    public DictLinear(V def) {
        this(def, new LinkedList<>(), new LinkedList<>());
    }

    public DictLinear(V def, List<K> keys, List<V> values) {
        this.def = def;
        this.keys = keys;
        this.values = values;
    }

    @Override
    public V map(K key) {
        int i = 0;
        for (K k : keys) {
            if (k == key) {
                return values.get(i);
            }
            i++;
        }
        return def;
    }

    @Override
    public int length() {
        return keys.size();
    }

    @Override
    public void accept(K key, V value) {
        keys.add(key);
        values.add(value);
    }

    @Override
    public PSource<K> keys() {
        return new PsOfIterator<>(keys.iterator());
    }
}
