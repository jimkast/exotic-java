package org.jimkast.exotic.parse.regex;

import java.util.Arrays;
import java.util.List;
import org.jimkast.exotic.binary.binary;

public final class dir_sequence implements dir {
    private final Iterable<dir> all;

    public dir_sequence(dir... all) {
        this(Arrays.asList(all));
    }

    public dir_sequence(Iterable<dir> all) {
        this.all = all;
    }

    @Override
    public int test(binary b, int pos, List<binary> groups) {
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
