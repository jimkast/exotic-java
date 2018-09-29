package org.jimkast.exotic.text;

import java.util.function.Consumer;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.possible.possible;

public final class split implements possible<binary> {
    private final binary origin;
    private final binary delim;
    private int index = 0;

    public split(binary origin, binary delim) {
        this.origin = origin;
        this.delim = delim;
    }
//
//    public split(text origin, text delim) {
//        possible<text> p = new mapped<>(
//            i -> new substring(origin, 0, i),
//            new possible.fixed<>((Scalar<Number>) new indexof(origin, delim))
//        );
//    }

    @Override
    public void supply(Consumer<? super binary> consumer) {
        if (index < origin.length()) {
            int from = index;
            int i = new indexof(new skipped(origin, from), delim).intValue();
            int until = i == -1 ? origin.length() - from : i;
            index += until + delim.length();
            consumer.accept(new substring(origin, from, until));
        }
    }
}
