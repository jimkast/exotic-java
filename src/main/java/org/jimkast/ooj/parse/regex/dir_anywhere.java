package org.jimkast.ooj.parse.regex;

import org.jimkast.exotic.binary.binary;
import org.jimkast.ooj.lang.ArrayTarget;
import org.jimkast.ooj.lang.Binary;

public final class dir_anywhere implements dir {
    private final dir origin;

    public dir_anywhere(dir origin) {
        this.origin = origin;
    }

    @Override
    public int test(Binary b, int pos, ArrayTarget<binary> groups) {
        int a = -1;
        int max = b.length() - pos - 1;
        for (int i = 0; i < max && a == -1; i++) {
            a = origin.test(b, pos + i, groups);
        }
        return a;
    }
}
