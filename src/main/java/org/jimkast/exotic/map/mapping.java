package org.jimkast.exotic.map;

import org.jimkast.exotic.data.binary;

public interface mapping<T> {
    T map(binary key);
}
