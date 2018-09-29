package org.jimkast.exotic.map;


import org.jimkast.exotic.binary.binary;

public interface mapping<T> {
    T map(binary key);
}
