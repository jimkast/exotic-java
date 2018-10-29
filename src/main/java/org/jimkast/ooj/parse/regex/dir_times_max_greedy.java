package org.jimkast.ooj.parse.regex;

import org.jimkast.exotic.binary.binary;
import org.jimkast.ooj.lang.ArrayTarget;
import org.jimkast.ooj.lang.Binary;

public final class dir_times_max_greedy implements dir {
    private final int max;
    private final dir origin;

    public dir_times_max_greedy(int max, dir origin) {
        this.max = max;
        this.origin = origin;
    }

    @Override
    public int test(Binary b, int pos, ArrayTarget<binary> groups) {
        int len = 0;
        int i = 0;
        int count = pos;
        while (i++ < max && len != -1) {
            len = origin.test(b, count, groups);
            count += len;
        }
        return count - pos;
    }
}
