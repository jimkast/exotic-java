package org.jimkast.exotic.map;


public interface Mapping<K, V> {
    V map(K key);
}
