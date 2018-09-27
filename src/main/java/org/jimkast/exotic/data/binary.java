package org.jimkast.exotic.data;

import java.io.IOException;
import java.io.OutputStream;
import org.jimkast.exotic.io.bs.BytesSource;

public interface binary {
    int at(int i);

    int length();


    final class str implements binary, BytesSource {
        private final CharSequence seq;

        public str(CharSequence seq) {
            this.seq = seq;
        }

        @Override
        public int at(int i) {
            return seq.charAt(i);
        }

        @Override
        public int length() {
            return seq.length();
        }

        @Override
        public void print(OutputStream out) throws IOException {
        }
    }
}
