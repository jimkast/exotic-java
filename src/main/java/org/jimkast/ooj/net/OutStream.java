package org.jimkast.ooj.net;

import java.io.IOException;
import org.jimkast.ooj.heap.HeapBlock;

public interface OutStream {
    void write(HeapBlock heap) throws IOException;
}
