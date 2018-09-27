package org.jimkast.exotic.parse;

import java.io.IOException;
import java.io.InputStream;

public interface source {
    void consume(InputStream is) throws IOException;
}
