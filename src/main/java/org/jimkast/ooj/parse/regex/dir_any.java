package org.jimkast.ooj.parse.regex;

import java.util.Arrays;
import org.jimkast.exotic.binary.binary;
import org.jimkast.ooj.lang.ArrayTarget;
import org.jimkast.ooj.lang.Binary;

public final class dir_any implements dir {
    private final Iterable<dir> all;

    public dir_any(dir... all) {
        this(Arrays.asList(all));
    }

    public dir_any(Iterable<dir> all) {
        this.all = all;
    }

    @Override
    public int test(Binary b, int pos, ArrayTarget<binary> groups) {
        for (dir dir : all) {
            int result = dir.test(b, pos, groups);
            if (result > -1) {
                return result;
            }
        }
        return -1;
    }
}
