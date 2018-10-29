package org.jimkast.ooj.parse.regex;

import java.util.function.IntPredicate;
import org.jimkast.exotic.binary.binary;
import org.jimkast.ooj.lang.ArrayTarget;
import org.jimkast.ooj.lang.Binary;

public final class dir_single implements dir {
    private final IntPredicate check;

    public dir_single(IntPredicate check) {
        this.check = check;
    }

    @Override
    public int test(Binary b, int pos, ArrayTarget<binary> groups) {
        return check.test(b.map(pos)) ? 1 : -1;
    }
}
