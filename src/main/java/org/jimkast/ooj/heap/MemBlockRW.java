package org.jimkast.ooj.heap;

public interface MemBlockRW extends MemBlockR, MemBlockW {
    MemBlockRW slice(int offset, int length);
}
