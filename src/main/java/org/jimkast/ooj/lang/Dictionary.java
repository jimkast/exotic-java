package org.jimkast.ooj.lang;

public interface Dictionary<K, V> extends Mapping<K, V> {
    SourceWithLength<K> keys();
}
