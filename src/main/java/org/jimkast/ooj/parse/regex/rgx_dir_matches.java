package org.jimkast.ooj.parse.regex;

import java.util.Collections;
import org.jimkast.ooj.array.ArrayJdk;
import org.jimkast.ooj.bisource.BiSource;
import org.jimkast.ooj.bisource.BiTarget;
import org.jimkast.ooj.lang.Binary;

public final class rgx_dir_matches implements BiSource<Integer, Integer> {
    private final Binary b;
    private final dir d;
    private int cur = 0;

    public rgx_dir_matches(Binary b, dir d) {
        this.b = b;
        this.d = d;
    }

    @Override
    public void feed(BiTarget<Integer, Integer> target) {
        int max = b.length();
        if (cur >= max) {
            return;
        }
        int len = -1;
        int cursor = cur;
        while (len == -1 && cursor < max) {
            len = d.test(b, cursor++, new ArrayJdk<>(Collections.emptyList()));
        }
        if (len > -1) {
            target.accept(cursor - 1, len);
            cur = cursor;
        }
    }
}
