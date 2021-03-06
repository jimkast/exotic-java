package org.jimkast.ooj.net;

import java.io.Closeable;
import java.io.IOException;

public interface ConnFactory extends Closeable {
    Conn establish() throws IOException;
}
