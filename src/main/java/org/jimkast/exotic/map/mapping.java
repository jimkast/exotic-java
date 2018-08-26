package org.jimkast.exotic.map;

import org.cactoos.Bytes;

public interface mapping<T> {
    T map(Bytes key);
}
