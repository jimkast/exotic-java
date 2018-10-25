package org.jimkast.ooj.source;


import org.jimkast.ooj.map.Mapping;
import org.jimkast.ooj.source.PSource;
import org.jimkast.ooj.source.Scalar;

public final class ScalarMapping<V> implements Scalar<V> {
    private final PSource<V> source;
    private final Mapping<PSource<V>, V> mapping;

    public ScalarMapping(PSource<V> source, Mapping<PSource<V>, V> mapping) {
        this.source = source;
        this.mapping = mapping;
    }

    @Override
    public V value() {
        return mapping.map(source);
    }
}
