package org.jimkast.ooj.net;

import java.io.IOException;

public interface OutStream {
    void accept(byte[] b, int offset, int length) throws IOException;
}
