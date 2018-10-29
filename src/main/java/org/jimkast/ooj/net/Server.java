package org.jimkast.ooj.net;

import java.io.Closeable;
import java.io.IOException;

public interface Server {
    Closeable start() throws IOException;
}
