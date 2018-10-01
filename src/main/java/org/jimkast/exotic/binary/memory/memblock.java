package org.jimkast.exotic.binary.memory;

import java.io.IOException;
import java.io.OutputStream;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.io.bs.bsource;

public interface memblock extends binary, bsource, bout {
    @Override
    int at(int i);

    @Override
    void put(int i, byte b);

    @Override
    int length();

    memblock resize(Number offset, Number length);

    @Override
    void transferTo(OutputStream out) throws IOException;
}
