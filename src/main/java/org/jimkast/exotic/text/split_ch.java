package org.jimkast.exotic.text;

import java.util.function.Consumer;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.possible.possible;

public final class split_ch implements possible<binary> {
    private final binary origin;
    private final char delim;
    private int index = 0;

    public split_ch(binary origin, char delim) {
        this.origin = origin;
        this.delim = delim;
    }

    @Override
    public void supply(Consumer<? super binary> consumer) {
        if (index <= origin.length()) {
            int from = index;
            int until = new chindex(new skipped(origin, index), delim).intValue();
            this.index += until + 1;
            if (until != -1) {
                consumer.accept(new substring(origin, from, until));
            }
        }
    }
}
