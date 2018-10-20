package org.jimkast.exotic.heap;

import java.io.IOException;

public interface InStream {
    int read(HeapBlock heap) throws IOException;
}
