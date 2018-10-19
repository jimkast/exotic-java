package org.jimkast.exotic.net;

import java.io.IOException;

public interface OutStream {
    void write(byte[] block, int offset, int len) throws IOException;
}
