package org.jimkast.exotic.net;

import java.io.Closeable;
import java.io.IOException;
import org.jimkast.exotic.heap.Conn;

public interface ConnFactory extends Closeable {
    Conn establish() throws IOException;
}
