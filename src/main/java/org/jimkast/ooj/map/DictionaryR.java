package org.jimkast.ooj.map;

import org.jimkast.ooj.bisource.BiSourceStream;
import org.jimkast.ooj.lang.Quantity;

public interface DictionaryR<K, V> extends Mapping<K, V>, Quantity, BiSourceStream<K, V> {
}
