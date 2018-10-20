package org.jimkast.exotic.string;

import java.io.IOException;

public interface MemBlockW extends Countable, IntMapping {
    void write(int skip, byte[] block, int offset, int len) throws IOException;

    @Override
    int length();

    @Override
    int map(int offset);
}
