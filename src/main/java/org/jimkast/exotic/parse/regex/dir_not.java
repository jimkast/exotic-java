package org.jimkast.exotic.parse.regex;

import java.util.List;
import org.jimkast.exotic.binary.binary;

public final class dir_not implements dir {
    private final dir origin;

    public dir_not(dir origin) {
        this.origin = origin;
    }

    @Override
    public int test(binary b, int pos, List<binary> groups) {
        return origin.test(b, pos, groups) > -1 ? -1 : 0;
    }
}
