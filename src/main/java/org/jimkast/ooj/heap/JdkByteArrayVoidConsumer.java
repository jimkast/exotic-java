package org.jimkast.ooj.heap;

import java.io.IOException;

public interface JdkByteArrayVoidConsumer {
    void accept(byte[] b, int offset, int length) throws IOException;
}
