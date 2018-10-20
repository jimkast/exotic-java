package org.jimkast.exotic.string;

import java.io.IOException;
import org.jimkast.exotic.net.OutStream;

public interface MemBlockR extends Countable, IntMapping, MemInput {
    @Override
    int length();

    @Override
    int map(int offset);

    @Override
    void printTo(OutStream out, int offset, int length) throws IOException;
}
