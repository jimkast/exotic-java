package org.jimkast.ooj.net;

import java.io.IOException;

public interface Session {
    void accept(Conn channel) throws IOException;
}
