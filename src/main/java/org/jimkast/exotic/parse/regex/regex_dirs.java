package org.jimkast.exotic.parse.regex;

import java.util.ArrayList;
import java.util.function.Consumer;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.possible.possible;
import org.jimkast.exotic.text.headof;

public final class regex_dirs implements possible<binary> {
    private final binary b;
    private final dir d;

    public regex_dirs(binary b, dir d) {
        this.b = b;
        this.d = d;
    }

    @Override
    public void supply(Consumer<? super binary> consumer) {
        int pos = d.test(b, 0, new ArrayList<>());
        if(pos > -1) {
            consumer.accept(new headof(pos, b));
        }
    }
}
