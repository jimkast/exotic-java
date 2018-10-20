package org.jimkast.exotic.heap;

import java.io.IOException;

public interface MemBlockR extends Countable, IntMapping, MemInput {
    @Override
    int length();

    @Override
    int map(int offset);

    @Override
    void printTo(OutStream out, int offset, int length) throws IOException;
}
