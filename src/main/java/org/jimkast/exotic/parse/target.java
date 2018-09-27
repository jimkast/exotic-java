package org.jimkast.exotic.parse;

import java.io.IOException;

public interface target {
    void accept(String ev, chunk c) throws IOException;
}
