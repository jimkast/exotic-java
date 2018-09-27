package org.jimkast.exotic.possible2;

import org.cactoos.Scalar;
import org.jimkast.exotic.bool.bool;

public interface opt<T> extends Scalar<T> {
    bool has();

    T value();
}
