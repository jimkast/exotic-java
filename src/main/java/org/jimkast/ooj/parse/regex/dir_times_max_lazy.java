package org.jimkast.ooj.parse.regex;

import org.jimkast.exotic.binary.binary;
import org.jimkast.ooj.lang.ArrayTarget;
import org.jimkast.ooj.lang.Binary;

public final class dir_times_max_lazy implements dir {
    private final int max;
    private final dir origin;
    private final dir next;

    public dir_times_max_lazy(int max, dir origin, dir next) {
        this.max = max;
        this.origin = origin;
        this.next = next;
    }

    @Override
    public int test(Binary b, int pos, ArrayTarget<binary> groups) {
        return 0;
    }
}
