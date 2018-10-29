package org.jimkast.ooj.dict;

import java.util.LinkedList;
import org.jimkast.ooj.array.ArrayJdk;
import org.jimkast.ooj.bisource.BiPSource;
import org.jimkast.ooj.bisource.PsBiCombined2;
import org.jimkast.ooj.lang.ArrayTarget;
import org.jimkast.ooj.map.Dictionary;
import org.jimkast.ooj.source.PsOfArray;

public final class DictLinear<K, V> implements Dictionary<K, V> {
    private final V def;
    private final ArrayTarget<K> keys;
    private final ArrayTarget<V> values;

    public DictLinear(V def) {
        this(def, new ArrayJdk<>(new LinkedList<>()), new ArrayJdk<>(new LinkedList<>()));
    }

    public DictLinear(V def, ArrayTarget<K> keys, ArrayTarget<V> values) {
        this.def = def;
        this.keys = keys;
        this.values = values;
    }

    @Override
    public V map(K key) {
        int len = keys.length();
        for (int i = 0; i < len; i++) {
            if (key == keys.map(i)) {
                return values.map(i);
            }
        }
        return def;
    }

    @Override
    public int length() {
        return keys.length();
    }

    @Override
    public void accept(K key, V value) {
        keys.accept(key);
        values.accept(value);
    }

    @Override
    public BiPSource<K, V> stream() {
        return new PsBiCombined2<>(
            new PsOfArray<>(keys),
            new PsOfArray<>(values)
        );
    }
}
