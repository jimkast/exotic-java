package org.jimkast.exotic.map;


import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.number.types.array;
import org.jimkast.exotic.possible.possible;

public interface dict<T> extends possible1<T> {
    @Override
    possible<T> map(binary key);

    void put(binary key, T value);

    array<binary> keys();
}
