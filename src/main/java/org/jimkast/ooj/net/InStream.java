package org.jimkast.ooj.net;

import java.io.IOException;
import org.jimkast.ooj.heap.HeapBlock;

public interface InStream {
    int read(HeapBlock heap) throws IOException;
}
