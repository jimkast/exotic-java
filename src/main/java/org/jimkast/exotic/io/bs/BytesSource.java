package org.jimkast.exotic.io.bs;

import java.io.IOException;
import java.io.OutputStream;

public interface BytesSource {
    void print(OutputStream out) throws IOException;

    BytesSource EMPTY = out -> {
    };


    class env implements BytesSource {
        private final BytesSource origin;

        public env(BytesSource origin) {
            this.origin = origin;
        }

        @Override
        public final void print(OutputStream out) throws IOException {
            origin.print(out);
        }
    }
}
