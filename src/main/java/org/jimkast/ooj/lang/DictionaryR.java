package org.jimkast.ooj.lang;

public interface DictionaryR<K, V> extends Mapping<K, V>, Quantity {
    PSource<K> keys();
}
