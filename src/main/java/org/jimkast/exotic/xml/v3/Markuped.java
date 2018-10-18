package org.jimkast.exotic.xml.v3;

import org.jimkast.exotic.possible.possible;

public interface Markuped {
    possible<Markuped> query(CharSequence q);

    CharSequence text();

//    void serialize(OutputStream out);


    Markuped EMPTY = new Markuped() {
        @Override
        public possible<Markuped> query(CharSequence q) {
            return possible.empty.instance();
        }

        @Override
        public CharSequence text() {
            return "";
        }

//        @Override
//        public void serialize(OutputStream out) {
//        }
    };
}
