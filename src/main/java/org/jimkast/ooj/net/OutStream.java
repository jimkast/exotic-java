package org.jimkast.ooj.net;

import java.io.IOException;

public interface OutStream {
    void accept(byte[] b, int offset, int length) throws IOException;

    final class Smart implements OutStream {
        private final OutStream origin;

        public Smart(OutStream origin) {
            this.origin = origin;
        }

        public void accept(byte[] b) throws IOException {
            accept(b, 0, b.length);
        }

        @Override
        public void accept(byte[] b, int offset, int length) throws IOException {
            origin.accept(b, offset, length);
        }
    }
}
