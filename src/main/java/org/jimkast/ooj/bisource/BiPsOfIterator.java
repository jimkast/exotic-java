package org.jimkast.ooj.bisource;

import java.util.Iterator;
import java.util.Map;

public final class BiPsOfIterator<K, V> implements BiSource<K, V> {
    private final Iterator<? extends Map.Entry<K, V>> iterator;

    public BiPsOfIterator(Iterator<? extends Map.Entry<K, V>> iterator) {
        this.iterator = iterator;
    }

    @Override
    public void feed(BiTarget<K, V> target) {
        if (iterator.hasNext()) {
            Map.Entry<K, V> pair = iterator.next();
            target.accept(pair.getKey(), pair.getValue());
        }
    }
}
