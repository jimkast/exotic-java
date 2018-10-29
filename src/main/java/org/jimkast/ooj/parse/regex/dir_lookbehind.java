package org.jimkast.ooj.parse.regex;

import org.jimkast.exotic.binary.binary;
import org.jimkast.ooj.lang.ArrayTarget;
import org.jimkast.ooj.lang.Binary;

public final class dir_lookbehind implements dir {
    private final dir d;
    private final dir behind;

    public dir_lookbehind(dir d, dir behind) {
        this.d = d;
        this.behind = behind;
    }

    @Override
    public int test(Binary b, int pos, ArrayTarget<binary> groups) {
        int behind_res = behind.test(b, pos, groups);
        return behind_res == -1 ? behind_res : d.test(b, pos + behind_res, groups);
    }
}
