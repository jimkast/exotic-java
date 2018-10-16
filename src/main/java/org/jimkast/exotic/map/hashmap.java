package org.jimkast.exotic.map;

import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.memory.binaryRW;
import org.jimkast.exotic.number.types.array;
import org.jimkast.exotic.possible.possible;

public final class hashmap<T> implements dict<T> {
    private final mapping<Number> mapping;
    private final binaryRW memory;

    public hashmap(mapping<Number> mapping, binaryRW memory) {
        this.mapping = mapping;
        this.memory = memory;
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
        return null;
    }
}
