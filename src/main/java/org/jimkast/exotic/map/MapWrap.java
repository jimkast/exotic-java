package org.jimkast.exotic.map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.cactoos.Scalar;
import org.cactoos.scalar.UncheckedScalar;

public class MapWrap<K, V> implements Map<K, V> {
    private final UncheckedScalar<Map<K, V>> map;

    public MapWrap(Map<K, V> map) {
        this(() -> map);
    }

    public MapWrap(Scalar<Map<K, V>> map) {
        this(new UncheckedScalar<>(map));
    }

    public MapWrap(UncheckedScalar<Map<K, V>> map) {
        this.map = map;
    }

    @Override
    public final int size() {
        return map.value().size();
    }

    @Override
    public final boolean isEmpty() {
        return map.value().isEmpty();
    }

    @Override
    public final boolean containsKey(Object key) {
        return map.value().containsKey(key);
    }

    @Override
    public final boolean containsValue(Object value) {
        return map.value().containsValue(value);
    }

    @Override
    public final V get(Object key) {
        return map.value().get(key);
    }

    @Override
    public final V put(K key, V value) {
        return map.value().put(key, value);
    }

    @Override
    public final V remove(Object key) {
        return map.value().remove(key);
    }

    @Override
    public final void putAll(Map<? extends K, ? extends V> m) {
        map.value().putAll(m);
    }

    @Override
    public final void clear() {
        map.value().clear();
    }

    @Override
    public final Set<K> keySet() {
        return map.value().keySet();
    }

    @Override
    public final Collection<V> values() {
        return map.value().values();
    }

    @Override
    public final Set<Entry<K, V>> entrySet() {
        return map.value().entrySet();
    }

    @Override
    public String toString() {
        return map.value().toString();
    }
}
