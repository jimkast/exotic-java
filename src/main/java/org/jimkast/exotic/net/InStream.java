package org.jimkast.exotic.net;

import java.io.IOException;
import org.jimkast.exotic.heap.HeapBlock;

public interface InStream {
    int read(HeapBlock heap) throws IOException;
}
