package org.jimkast.exotic.parse.regex;

import java.util.Collections;
import java.util.function.Consumer;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.possible.possible;

public final class rgx_dir_matches implements possible<match> {
    private final binary b;
    private final dir d;
    private int cur = 0;

    public rgx_dir_matches(binary b, dir d) {
        this.b = b;
        this.d = d;
    }

    @Override
    public void supply(Consumer<? super match> consumer) {
        int max = b.length();
        if (cur < max) {
            int len = -1;
            int cursor = cur;
            while (len == -1 && cursor < max) {
                len = d.test(b, cursor++, Collections.emptyList());
            }
            if (len > -1) {
                consumer.accept(new match.Simple(cursor - 1, len));
                cur = cursor;
            }
        }
    }
}
