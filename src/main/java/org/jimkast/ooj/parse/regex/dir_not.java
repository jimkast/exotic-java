package org.jimkast.ooj.parse.regex;

import org.jimkast.exotic.binary.binary;
import org.jimkast.ooj.lang.ArrayTarget;
import org.jimkast.ooj.lang.Binary;

public final class dir_not implements dir {
    private final dir origin;

    public dir_not(dir origin) {
        this.origin = origin;
    }

    @Override
    public int test(Binary b, int pos, ArrayTarget<binary> groups) {
        return origin.test(b, pos, groups) > -1 ? -1 : 0;
    }
}
