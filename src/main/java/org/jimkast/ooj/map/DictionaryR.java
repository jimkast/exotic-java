package org.jimkast.ooj.map;

import org.jimkast.ooj.lang.Quantity;
import org.jimkast.ooj.map.Mapping;
import org.jimkast.ooj.source.PSource;

public interface DictionaryR<K, V> extends Mapping<K, V>, Quantity {
    PSource<K> keys();
}
