package org.jimkast.exotic.parse;

import java.io.IOException;
import java.io.OutputStream;
import org.cactoos.io.InputOf;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.io.bs.bs_input;
import org.jimkast.exotic.io.bs.bsource;

public interface chunk extends binary, bsource {
    @Override
    int at(int i);

    @Override
    int length();

    @Override
    void transferTo(OutputStream out) throws IOException;


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
        public void transferTo(OutputStream out) throws IOException {
            new bs_input(new InputOf(s)).transferTo(out);
        }
    }
}
