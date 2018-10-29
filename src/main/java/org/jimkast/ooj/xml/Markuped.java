package org.jimkast.ooj.xml;

import java.util.function.Consumer;
import org.jimkast.exotic.possible.possible;

public interface Markuped extends possible<Markuped> {
    Markuped query(CharSequence q);

    CharSequence text();

    @Override
    void supply(Consumer<? super Markuped> consumer);

    //    void serialize(OutputStream out);


    Markuped EMPTY = new Markuped() {
        @Override
        public Markuped query(CharSequence q) {
            return this;
        }

        @Override
        public CharSequence text() {
            return "";
        }

        @Override
        public void supply(Consumer<? super Markuped> consumer) {

        }
    };
}
