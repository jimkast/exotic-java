package org.jimkast.ooj.net;

import java.io.IOException;
import java.nio.channels.SocketChannel;
import org.jimkast.ooj.heap.HeapBlock;

public final class ConnTcpNio implements Conn {
    private final SocketChannel s;

    public ConnTcpNio(SocketChannel s) {
        this.s = s;
    }

    @Override
    public int read(HeapBlock heap) throws IOException {
        return s.read(heap.buffer());
    }

    @Override
    public void write(HeapBlock heap) throws IOException {
        s.write(heap.buffer());
    }

    @Override
    public void close() throws IOException {
        s.close();
    }
}
