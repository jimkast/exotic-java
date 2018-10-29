package org.jimkast.ooj.parse.regex;

import org.jimkast.exotic.binary.binary;
import org.jimkast.ooj.lang.ArrayTarget;
import org.jimkast.ooj.lang.Binary;

public final class dir_lookahead implements dir {
    private final dir d;
    private final dir ahead;

    public dir_lookahead(dir d, dir ahead) {
        this.d = d;
        this.ahead = ahead;
    }

    @Override
    public int test(Binary b, int pos, ArrayTarget<binary> groups) {
        int res = d.test(b, pos, groups);
        if (res == 1) {
            return res;
        }
        int ahead_res = ahead.test(b, pos + res, groups);
        if (ahead_res == -1) {
            return ahead_res;
        }
        return res;
    }
}
