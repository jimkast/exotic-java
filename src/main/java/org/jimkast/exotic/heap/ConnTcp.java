package org.jimkast.exotic.heap;

import java.io.IOException;
import java.net.Socket;

public final class ConnTcp implements Conn {
    private final Socket s;

    public ConnTcp(Socket s) {
        this.s = s;
    }

    @Override
    public int read(HeapBlock heap) throws IOException {
        HeapAddr addr = heap.address();
        return s.getInputStream().read(addr.jarr, addr.offset, heap.length());
    }

    @Override
    public void write(HeapBlock heap) throws IOException {
        HeapAddr addr = heap.address();
        s.getOutputStream().write(addr.jarr, addr.offset, heap.length());
    }

    @Override
    public void close() throws IOException {
        s.close();
    }
}
