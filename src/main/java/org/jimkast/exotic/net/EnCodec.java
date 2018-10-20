package org.jimkast.exotic.net;

import org.jimkast.exotic.heap.InStream;

public interface EnCodec<T>  {
    T decode(InStream in);
}
