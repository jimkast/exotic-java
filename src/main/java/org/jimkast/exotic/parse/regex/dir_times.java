package org.jimkast.exotic.parse.regex;

import java.util.List;
import org.jimkast.exotic.binary.binary;

public final class dir_times implements dir {
    private final int from;
    private final int to;
    private final dir origin;

    public dir_times(int from, int to, dir origin) {
        this.from = from;
        this.to = to;
        this.origin = origin;
    }

    @Override
    public int test(binary b, int pos, List<binary> groups) {
        int i;
        int j = 0;
        int cur = 0;
        int max = from + to;
        for (i = 0; i < max && (cur = origin.test(b, pos + j, groups)) > -1; j+=cur, i++) {

        }
        return i < from ? -1 : j;
    }
}
