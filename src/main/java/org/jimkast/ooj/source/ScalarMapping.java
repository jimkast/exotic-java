package org.jimkast.ooj.source;


import org.jimkast.ooj.map.Mapping;

public final class ScalarMapping<V> implements Scalar<V> {
    private final Source<V> source;
    private final Mapping<Source<V>, V> mapping;

    public ScalarMapping(Source<V> source, Mapping<Source<V>, V> mapping) {
        this.source = source;
        this.mapping = mapping;
    }

    @Override
    public V value() {
        return mapping.map(source);
    }
}
