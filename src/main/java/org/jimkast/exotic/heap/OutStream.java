package org.jimkast.exotic.heap;

import java.io.IOException;

public interface OutStream {
    void write(HeapBlock heap) throws IOException;
}
