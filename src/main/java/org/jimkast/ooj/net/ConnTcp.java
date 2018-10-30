package org.jimkast.ooj.net;

import java.io.IOException;
import java.net.Socket;
import org.jimkast.ooj.heap.HeapBlock;

public final class ConnTcp implements Conn {
    private final Socket s;

    public ConnTcp(Socket s) {
        this.s = s;
    }

    @Override
    public int read(HeapBlock heap) throws IOException {
        return heap.readFrom(s.getInputStream());
    }

    @Override
    public void accept(HeapBlock heap) throws IOException {
        heap.writeTo(s.getOutputStream());
    }

    @Override
    public void close() throws IOException {
        s.close();
    }
}