package org.jimkast.exotic.parse;

import java.io.IOException;
import java.io.OutputStream;
import org.cactoos.io.InputOf;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.io.bs.BsInput;
import org.jimkast.exotic.io.bs.BytesSource;

public interface chunk extends binary, BytesSource {
    @Override
    int at(int i);

    @Override
    int length();

    @Override
    void print(OutputStream out) throws IOException;


    final class str implements chunk {
        private final String s;

        public str(String s) {
            this.s = s;
        }

        @Override
        public int at(int i) {
            return s.charAt(i);
        }

        @Override
        public int length() {
            return s.length();
        }

        @Override
        public void print(OutputStream out) throws IOException {
            new BsInput(new InputOf(s)).print(out);
        }
    }
}
