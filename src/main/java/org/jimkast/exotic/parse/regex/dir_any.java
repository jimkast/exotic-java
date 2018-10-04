package org.jimkast.exotic.parse.regex;

import java.util.Arrays;
import java.util.List;
import org.jimkast.exotic.binary.binary;

public final class dir_any implements dir {
    private final Iterable<dir> all;

    public dir_any(dir... all) {
        this(Arrays.asList(all));
    }

    public dir_any(Iterable<dir> all) {
        this.all = all;
    }

    @Override
    public int test(binary b, int pos, List<binary> groups) {
        for (dir dir : all) {
            int result = dir.test(b, pos, groups);
            if (result > -1) {
                return result;
            }
        }
        return -1;
    }
}
