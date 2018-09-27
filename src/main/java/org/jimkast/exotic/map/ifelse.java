package org.jimkast.exotic.map;

import org.jimkast.exotic.data.binary;
import org.jimkast.exotic.number.types.array;
import org.jimkast.exotic.possible.possible;

public final class ifelse<T> implements dict<T> {
    private final array<binary> keys;
    private final array<T> values;

    public ifelse(array<binary> keys, array<T> values) {
        this.keys = keys;
        this.values = values;
    }

    @Override
    public possible<T> map(binary key) {
        return null;
    }

    @Override
    public void put(binary key, T value) {

    }

    @Override
    public array<binary> keys() {
        return keys;
    }
}
