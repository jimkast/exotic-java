package org.jimkast.exotic.net;

import java.io.IOException;

public interface InStream {
    int read(byte[] block, int offset, int len) throws IOException;
}
