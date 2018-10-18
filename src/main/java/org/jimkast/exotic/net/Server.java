package org.jimkast.exotic.net;

import java.io.Closeable;
import java.io.IOException;

public interface Server {
    Closeable start() throws IOException;
}
