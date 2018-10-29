package org.jimkast.ooj.parse.regex;

import org.jimkast.exotic.binary.binary;
import org.jimkast.ooj.lang.ArrayTarget;
import org.jimkast.ooj.lang.Binary;

public final class dir_dot implements dir {
    @Override
    public int test(Binary b, int pos, ArrayTarget<binary> groups) {
        return pos < b.length() ? 1 : -1;
    }
}
