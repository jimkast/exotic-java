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
        int cur;
        int i = 0;
        int j = 0;
        int max = from + to;
        int remaining = b.length() - pos;
        while (i < max && (j < remaining) && (cur = origin.test(b, pos + j, groups)) > -1) {
            j += cur;
            i++;
        }
        return i < from ? -1 : j;
    }
}
