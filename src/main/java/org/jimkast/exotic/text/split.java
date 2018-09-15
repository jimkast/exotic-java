package org.jimkast.exotic.text;

import java.util.function.Consumer;
import org.jimkast.exotic.possible.possible;

public final class split implements possible<text> {
    private final text origin;
    private final text delim;
    private int index = 0;

    public split(text origin, text delim) {
        this.origin = origin;
        this.delim = delim;
    }

    @Override
    public void supply(Consumer<? super text> consumer) {
        if (index < origin.length()) {
            int from = index;
            int until = new indexof(new substring(origin, from), delim).intValue();
            if (until != -1) {
                index += until + delim.length();
                consumer.accept(new substring(origin, from, until));
            } else {
                index = origin.length();
                consumer.accept(new substring(origin, from));
            }
        }
    }
}
