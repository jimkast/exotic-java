package org.jimkast.exotic.xml.v3;

import java.io.OutputStream;
import org.jimkast.exotic.possible.possible;

public interface Markuped {
    possible<Markuped> query(CharSequence q);

    CharSequence text();

    void serialize(OutputStream out);


    Markuped EMPTY = new Markuped() {
        private final possible<Markuped> empty = new possible.empty<>();

        @Override
        public possible<Markuped> query(CharSequence q) {
            return empty;
        }

        @Override
        public CharSequence text() {
            return "";
        }

        @Override
        public void serialize(OutputStream out) {
        }
    };
}
