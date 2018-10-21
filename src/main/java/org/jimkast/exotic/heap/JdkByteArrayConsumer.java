package org.jimkast.exotic.heap;

public interface JdkByteArrayConsumer<T> {
    T accept(byte[] b, int offset, int length);
}
