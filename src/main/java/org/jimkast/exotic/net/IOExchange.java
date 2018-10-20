package org.jimkast.exotic.net;

import org.jimkast.exotic.heap.InStream;
import org.jimkast.exotic.io.bs.bsource;

public interface IOExchange {
    bsource exchange(InStream in);
}
