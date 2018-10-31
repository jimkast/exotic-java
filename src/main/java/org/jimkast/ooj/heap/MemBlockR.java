package org.jimkast.ooj.heap;

import java.io.IOException;
import org.jimkast.ooj.lang.Binary;
import org.jimkast.ooj.net.ByteSource;
import org.jimkast.ooj.net.OutStream;

public interface MemBlockR extends Binary, ByteSource {
    MemBlockR slice(int offset, int length);


    class Env implements MemBlockR {
        private final MemBlockR origin;

        public Env(MemBlockR origin) {
            this.origin = origin;
        }

        @Override
        public final int length() {
            return origin.length();
        }

        @Override
        public void feed(OutStream out) throws IOException {
            origin.feed(out);
        }

        @Override
        public final int map(int i) {
            return origin.map(i);
        }

        @Override
        public MemBlockR slice(int offset, int length) {
            return origin.slice(offset, length);
        }
    }
}
