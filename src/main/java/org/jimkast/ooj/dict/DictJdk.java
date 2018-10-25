package org.jimkast.ooj.dict;

import java.util.Map;
import org.jimkast.ooj.map.Dictionary;
import org.jimkast.ooj.source.PSource;
import org.jimkast.ooj.source.PsOfIterator;

public final class DictJdk<K, V> implements Dictionary<K, V> {
    private final V def;
    private final Map<K, V> map;

    public DictJdk(V def, Map<K, V> map) {
        this.def = def;
        this.map = map;
    }

    @Override
    public V map(K key) {
        return map.getOrDefault(key, def);
    }

    @Override
    public void accept(K key, V value) {
        map.put(key, value);
    }

    @Override
    public int length() {
        return map.size();
    }

    @Override
    public PSource<K> keys() {
        return new PsOfIterator<>(map.keySet().iterator());
    }
}
