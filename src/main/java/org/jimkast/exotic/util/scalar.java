package org.jimkast.exotic.util;

import org.cactoos.Scalar;

public interface scalar<T> extends Scalar<T> {
    @Override
    T value();
}
