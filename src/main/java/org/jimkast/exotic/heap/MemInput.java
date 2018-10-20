package org.jimkast.exotic.heap;

import java.io.IOException;

public interface MemInput {
    void printTo(OutStream out, int offset, int length) throws IOException;
}
