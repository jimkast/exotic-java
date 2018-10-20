package org.jimkast.exotic.heap;

import java.io.Closeable;
import java.io.IOException;
import org.jimkast.exotic.heap.HeapBlock;
import org.jimkast.exotic.heap.InStream;
import org.jimkast.exotic.heap.OutStream;

public interface Conn extends InStream, OutStream, Closeable {
    int read(HeapBlock heap) throws IOException;

    void write(HeapBlock heap) throws IOException;

    void close() throws IOException;
}
