package org.jimkast.ooj.map;

import java.util.Arrays;
import org.jimkast.ooj.source.PsFlattened;
import org.jimkast.ooj.source.PsMapped;
import org.jimkast.ooj.source.PsOfIterable;
import org.jimkast.ooj.source.Source;

public final class Any2<K, V> implements PMapping<K, V> {
    private final Source<Source<PMapping<K, V>>> all;

    @SafeVarargs
    public Any2(PMapping<K, V>... all) {
        this(Arrays.asList(all));
    }

    public Any2(Iterable<PMapping<K, V>> all) {
        this(new PsOfIterable<>(all));
    }

    public Any2(Source<Source<PMapping<K, V>>> all) {
        this.all = all;
    }

    @Override
    public Source<V> map(K key) {
        return new PsFlattened<>(new PsMapped<>(key1 -> key1.map(key), new PsFlattened<>(all)));
    }
}
