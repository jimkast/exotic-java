package org.jimkast.exotic.net;

import java.io.IOException;

public interface session {
    void accept(conn channel) throws IOException;
}
