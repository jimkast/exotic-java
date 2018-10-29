package org.jimkast.ooj.net;

public interface EnCodec<T>  {
    T decode(InStream in);
}
