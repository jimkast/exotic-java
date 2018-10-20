package org.jimkast.exotic.net;

import java.io.IOException;
import org.jimkast.exotic.heap.Conn;

public interface Session {
    void accept(Conn channel) throws IOException;
}
