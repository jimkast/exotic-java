package org.jimkast.exotic.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import org.jimkast.exotic.heap.HeapBlock;

public final class ConnUdp implements Conn {
    private final DatagramSocket s;

    public ConnUdp(DatagramSocket s) {
        this.s = s;
    }

    @Override
    public int read(HeapBlock heap) throws IOException {
        DatagramPacket p = heap.supply(DatagramPacket::new);
        s.receive(p);
        return p.getLength();
    }

    @Override
    public void write(HeapBlock heap) throws IOException {
        s.send(heap.supply(DatagramPacket::new));
    }

    @Override
    public void close() {
        s.close();
    }
}
