package org.jimkast.ooj.map;

import java.util.Arrays;
import org.jimkast.ooj.source.PsFlattened;
import org.jimkast.ooj.source.PsFlattenedSingle;
import org.jimkast.ooj.source.PsMapped;
import org.jimkast.ooj.source.PsOfIterable;
import org.jimkast.ooj.source.Source;

public final class Any<K, V> implements PMapping<K, V> {
    private final Source<PMapping<K, V>> all;

    @SafeVarargs
    public Any(PMapping<K, V>... all) {
        this(Arrays.asList(all));
    }

    public Any(Iterable<PMapping<K, V>> all) {
        this(new PsFlattenedSingle<>(new PsOfIterable<>(all)));
    }

    public Any(Source<PMapping<K, V>> all) {
        this.all = all;
    }

    @Override
    public Source<V> map(K key) {
        return new PsFlattened<>(
            new PsMapped<>(
                p -> p.map(key),
                all
            )
        );
    }
}
