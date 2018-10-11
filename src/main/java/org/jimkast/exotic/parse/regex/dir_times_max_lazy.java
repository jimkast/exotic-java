package org.jimkast.exotic.parse.regex;

import java.util.List;
import org.jimkast.exotic.binary.binary;

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
    public int test(binary b, int pos, List<binary> groups) {
        return 0;
    }
}
