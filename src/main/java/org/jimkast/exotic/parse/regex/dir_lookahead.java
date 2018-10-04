package org.jimkast.exotic.parse.regex;

import java.util.List;
import org.jimkast.exotic.binary.binary;

public final class dir_lookahead implements dir {
    private final dir d;
    private final dir ahead;

    public dir_lookahead(dir d, dir ahead) {
        this.d = d;
        this.ahead = ahead;
    }

    @Override
    public int test(binary b, int pos, List<binary> groups) {
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
