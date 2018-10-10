package org.jimkast.exotic.parse.regex;

import java.util.List;
import org.jimkast.exotic.binary.binary;

public final class dir_anywhere implements dir {
    private final dir origin;

    public dir_anywhere(dir origin) {
        this.origin = origin;
    }

    @Override
    public int test(binary b, int pos, List<binary> groups) {
        int a = -1;
        int max = b.length() - pos - 1;
        for (int i = 0; i < max && a == -1; i++) {
            a = origin.test(b, pos + i, groups);
        }
        return a;
    }
}
