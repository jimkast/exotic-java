package org.jimkast.exotic.text;

import java.util.function.Consumer;
import org.jimkast.exotic.possible.possible;

public final class split_ch implements possible<text> {
    private final text origin;
    private final char delim;
    private int index = 0;

    public split_ch(text origin, char delim) {
        this.origin = origin;
        this.delim = delim;
    }

    @Override
    public void supply(Consumer<? super text> consumer) {
        if (index <= origin.length()) {
            int from = index;
            int until = new chindex(new substring(origin, index), delim).intValue();
            this.index += until + 1;
            if (until != -1) {
                consumer.accept(new substring(origin, from, until));
            }
        }
    }
}
