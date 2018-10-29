package org.jimkast.ooj.heap;

public interface JdkByteArraySource<T> {
    int feed(byte[] b, int offset, int length) throws Exception;
}
