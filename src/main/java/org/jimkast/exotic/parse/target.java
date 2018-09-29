package org.jimkast.exotic.parse;

import java.io.IOException;

public interface target {
    void accept(chunk ev, chunk c) throws IOException;
}
