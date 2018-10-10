package org.jimkast.exotic.parse.regex;

import java.util.Collections;
import java.util.function.Consumer;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.possible.possible;
import org.jimkast.exotic.text.substring;

public final class regex_dirs implements possible<binary> {
    private final binary b;
    private final dir d;
    private int cur = 0;

    public regex_dirs(binary b, dir d) {
        this.b = b;
        this.d = d;
    }

    @Override
    public void supply(Consumer<? super binary> consumer) {
        int len = -1;
        int max = b.length();
        if (cur >= max) {
            return;
        }
        int cursor = cur;
        while (len == -1 && cursor < max) {
            len = d.test(b, cursor++, Collections.emptyList());
        }
        if (len > -1) {
            consumer.accept(new substring(b, cursor - 1, len));
            cur = cursor;
        }
    }
}
