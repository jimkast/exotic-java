package org.jimkast.ooj.net;

import java.io.IOException;

public interface Back {
    void feed(Session session) throws IOException;
}
