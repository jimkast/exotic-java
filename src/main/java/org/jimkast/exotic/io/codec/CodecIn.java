package org.jimkast.exotic.io.codec;

import java.io.InputStream;

public interface CodecIn<T> {
    T decode(InputStream input);
}
