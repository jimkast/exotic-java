package org.jimkast.exotic.net;

import java.io.IOException;
import org.jimkast.exotic.heap.HeapBlock;

public interface OutStream {
    void write(HeapBlock heap) throws IOException;
}
