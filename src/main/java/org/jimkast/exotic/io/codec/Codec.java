package org.jimkast.exotic.io.codec;

import java.io.InputStream;
import org.jimkast.exotic.io.bs.BytesSource;

public interface Codec<T> extends CodecIn<T>, CodecOut<T> {
    @Override
    T decode(InputStream input);

    @Override
    BytesSource encode(T data);
}
