package org.jimkast.exotic.net;

import java.io.InputStream;

public interface conn {
    InputStream in();

    InputStream out();

    void close();
}
