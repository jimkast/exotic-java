package org.jimkast.ooj.net;

import java.io.Closeable;
import java.io.IOException;
import org.jimkast.ooj.heap.HeapBlock;

public interface Conn extends InStream, OutStream, Closeable {
    int read(HeapBlock heap) throws IOException;

    void accept(HeapBlock heap) throws IOException;

    void close() throws IOException;
}
