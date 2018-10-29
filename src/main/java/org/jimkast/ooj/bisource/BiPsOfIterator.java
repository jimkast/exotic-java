package org.jimkast.ooj.bisource;

import java.util.Iterator;
import java.util.Map;
import org.jimkast.ooj.cond.Cond;

public final class BiPsOfIterator<K, V> implements BiPSource<K, V> {
    private final Iterator<? extends Map.Entry<K, V>> iterator;

    public BiPsOfIterator(Iterator<? extends Map.Entry<K, V>> iterator) {
        this.iterator = iterator;
    }

    @Override
    public Cond feed(BiTarget<K, V> target) {
        if(!iterator.hasNext()) {
            return Cond.FALSE;
        }
        Map.Entry<K, V> pair = iterator.next();
        target.accept(pair.getKey(), pair.getValue());
        return Cond.TRUE;
    }
}
