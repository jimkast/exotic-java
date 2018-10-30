package org.jimkast.ooj.heap;

import java.io.IOException;
import org.jimkast.ooj.lang.IntArray;

public interface MemBlockW extends IntArray {
    void write(int skip, HeapBlockArray block) throws IOException;

    @Override
    int length();

    @Override
    int map(int offset);
}
