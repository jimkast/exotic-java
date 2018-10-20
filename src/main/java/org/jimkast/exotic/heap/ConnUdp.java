package org.jimkast.exotic.heap;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public final class ConnUdp implements Conn {
    private final DatagramSocket s;

    public ConnUdp(DatagramSocket s) {
        this.s = s;
    }

    @Override
    public int read(HeapBlock heap) throws IOException {
        HeapAddr addr = heap.address();
        DatagramPacket p = new DatagramPacket(addr.jarr, addr.offset, heap.length());
        s.receive(p);
        return p.getLength();
    }

    @Override
    public void write(HeapBlock heap) throws IOException {
        HeapAddr addr = heap.address();
        s.send(new DatagramPacket(addr.jarr, addr.offset, heap.length()));
    }

    @Override
    public void close() {
        s.close();
    }
}
