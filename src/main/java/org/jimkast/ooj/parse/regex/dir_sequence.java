package org.jimkast.ooj.parse.regex;

import java.util.Arrays;
import org.jimkast.exotic.binary.binary;
import org.jimkast.ooj.lang.ArrayTarget;
import org.jimkast.ooj.lang.Binary;

public final class dir_sequence implements dir {
    private final Iterable<dir> all;

    public dir_sequence(dir... all) {
        this(Arrays.asList(all));
    }

    public dir_sequence(Iterable<dir> all) {
        this.all = all;
    }

    @Override
    public int test(Binary b, int pos, ArrayTarget<binary> groups) {
        int count = 0;
        int len = b.length();
        for (dir dir : all) {
            int result = dir.test(b, pos + count, groups);
            if (result == -1) {
                return -1;
            }
            count += result;
            if (count >= len) {
                return -1;
            }
        }
        return count;
    }
}
