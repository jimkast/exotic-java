package org.jimkast.exotic.io.codec;

import java.io.InputStream;
import org.jimkast.exotic.io.bs.bsource;

public interface Codec<T> extends CodecIn<T>, CodecOut<T> {
    @Override
    T decode(InputStream input);

    @Override
    bsource encode(T data);
}
