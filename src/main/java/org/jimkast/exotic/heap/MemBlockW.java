package org.jimkast.exotic.heap;

import java.io.IOException;

public interface MemBlockW extends Countable, IntMapping {
    void write(int skip, HeapBlock block) throws IOException;

    @Override
    int length();

    @Override
    int map(int offset);
}
