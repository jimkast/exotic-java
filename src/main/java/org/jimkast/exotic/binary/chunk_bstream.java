package org.jimkast.exotic.binary;

import java.util.Iterator;

public interface chunk_bstream extends Iterator<binary> {
    @Override
    boolean hasNext();

    @Override
    binary next();
}
