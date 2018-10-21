package org.jimkast.exotic.net;

import java.io.IOException;

public interface Session {
    void accept(Conn channel) throws IOException;
}
