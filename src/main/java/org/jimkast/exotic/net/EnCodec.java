package org.jimkast.exotic.net;

public interface EnCodec<T>  {
    T decode(InStream in);
}
