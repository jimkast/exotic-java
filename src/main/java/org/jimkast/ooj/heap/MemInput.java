package org.jimkast.ooj.heap;

import java.io.IOException;
import org.jimkast.ooj.net.OutStream;

public interface MemInput {
    void printTo(OutStream out, int offset, int length) throws IOException;
}
