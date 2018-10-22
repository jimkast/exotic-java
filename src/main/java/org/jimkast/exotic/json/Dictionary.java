package org.jimkast.exotic.json;

import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.number.types.array;

public interface Dictionary<T> extends array<T> {
    T map(binary b);

    @Override
    T item(int i);

    @Override
    int length();
}