package org.jimkast.ooj.heap;

import org.jimkast.ooj.lang.Binary;
import org.jimkast.ooj.net.OutStream;

public interface MemBlockW extends Binary, OutStream {
    MemBlockW slice(int offset, int length);
}
