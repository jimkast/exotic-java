package org.jimkast.exotic.parse.regex;

import java.util.List;
import java.util.function.IntPredicate;
import org.jimkast.exotic.binary.binary;

public final class dir_single implements dir {
    private final IntPredicate check;

    public dir_single(IntPredicate check) {
        this.check = check;
    }

    @Override
    public int test(binary b, int pos, List<binary> groups) {
        return check.test(b.at(pos)) ? 1 : -1;
    }
}
