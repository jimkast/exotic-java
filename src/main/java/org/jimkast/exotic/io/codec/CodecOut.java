package org.jimkast.exotic.io.codec;

import org.jimkast.exotic.io.bs.BytesSource;

public interface CodecOut<T> {
    BytesSource encode(T data);
}
