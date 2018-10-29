package org.jimkast.ooj.heap;

import java.io.IOException;
import org.jimkast.ooj.lang.IntIntMapping;
import org.jimkast.ooj.lang.Quantity;

public interface MemBlockW extends Quantity, IntIntMapping {
    void write(int skip, HeapBlock block) throws IOException;

    @Override
    int length();

    @Override
    int map(int offset);
}
