package org.jimkast.exotic.net;

import java.io.Closeable;
import java.io.IOException;

public final class ServerSimple implements Server {
    private final BackCloseable back;
    private final Session session;

    public ServerSimple(BackCloseable back, Session session) {
        this.back = back;
        this.session = session;
    }

    @Override
    public Closeable start() throws IOException {
        back.feed(session);
        return back;
    }
}
