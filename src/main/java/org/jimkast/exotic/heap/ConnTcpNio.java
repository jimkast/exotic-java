package org.jimkast.exotic.heap;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public final class ConnTcpNio implements Conn {
    private final SocketChannel s;

    public ConnTcpNio(SocketChannel s) {
        this.s = s;
    }

    @Override
    public int read(HeapBlock heap) throws IOException {
        HeapAddr addr = heap.address();
        return s.read(ByteBuffer.wrap(addr.jarr, addr.offset, heap.length()));
    }

    @Override
    public void write(HeapBlock heap) throws IOException {
        HeapAddr addr = heap.address();
        s.write(ByteBuffer.wrap(addr.jarr, addr.offset, heap.length()));
    }

    @Override
    public void close() throws IOException {
        s.close();
    }
}
