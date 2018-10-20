package org.jimkast.exotic.heap;

import org.jimkast.exotic.memory.addr;

public interface Writeable {
    void accept(addr block);
}
