package org.jimkast.exotic.net;

import java.io.IOException;

public interface Conn extends InStream, OutStream {
    int read(byte[] block, int offset, int len) throws IOException;

    void write(byte[] block, int offset, int len) throws IOException;

    void close() throws IOException;
}
