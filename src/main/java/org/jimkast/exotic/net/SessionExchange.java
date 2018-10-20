package org.jimkast.exotic.net;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jimkast.exotic.heap.Conn;
import org.jimkast.exotic.heap.OutStreamCloseable;
import sun.misc.Unsafe;

public final class SessionExchange implements Session {
    private final IOExchange exchange;

    public SessionExchange(IOExchange exchange) {
        this.exchange = exchange;
    }

    @Override
    public void accept(Conn channel) throws IOException {
        long l = Unsafe.getUnsafe().allocateMemory(16);
        ByteBuffer.allocateDirect(500);
        exchange.exchange(channel).transferTo(new OutStreamCloseable.AsOutputStream(channel));
    }
}
