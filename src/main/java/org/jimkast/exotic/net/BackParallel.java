package org.jimkast.exotic.net;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.concurrent.Executor;

public final class BackParallel implements Back {
    private final Executor svc;
    private final Back origin;

    public BackParallel(Executor svc, Back origin) {
        this.svc = svc;
        this.origin = origin;
    }

    @Override
    public void feed(Session session) throws IOException {
        svc.execute(() -> {
            try {
                origin.feed(session);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        });
    }
}
