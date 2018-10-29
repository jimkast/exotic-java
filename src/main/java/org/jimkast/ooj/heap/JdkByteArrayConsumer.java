package org.jimkast.ooj.heap;

public interface JdkByteArrayConsumer<T> {
    T accept(byte[] b, int offset, int length);
}
