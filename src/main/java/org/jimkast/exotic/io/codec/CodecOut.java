package org.jimkast.exotic.io.codec;

import org.jimkast.exotic.io.bs.bsource;

public interface CodecOut<T> {
    bsource encode(T data);
}
