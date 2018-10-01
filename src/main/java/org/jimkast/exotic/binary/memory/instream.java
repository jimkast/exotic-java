package org.jimkast.exotic.binary.memory;

import java.io.IOException;

public interface instream {
    void read(memblock3 block);

    int available();

    void flush() throws IOException;

    void close() throws IOException;
}
