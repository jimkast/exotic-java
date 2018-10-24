package org.jimkast.ooj.dict;

import java.util.Map;
import java.util.Set;
import org.jimkast.ooj.lang.Cond;
import org.jimkast.ooj.lang.Dictionary;
import org.jimkast.ooj.lang.PSource;
import org.jimkast.ooj.lang.SourceWithLength;
import org.jimkast.ooj.lang.Target;
import org.jimkast.ooj.source.PsOfIterator;

public final class DictJdk<K, V> implements Dictionary<K, V> {
    private final Map<K, V> map;

    public DictJdk(Map<K, V> map) {
        this.map = map;
    }

    @Override
    public V map(K key) {
        return map.get(key);
    }

    @Override
    public SourceWithLength<K> keys() {
        final Set<K> set = map.keySet();
        final PSource<K> source = new PsOfIterator<>(set.iterator());
        return new SourceWithLength<K>() {
            @Override
            public Cond feed(Target<K> target) {
                return source.feed(target);
            }

            @Override
            public int length() {
                return set.size();
            }
        };
    }
}
