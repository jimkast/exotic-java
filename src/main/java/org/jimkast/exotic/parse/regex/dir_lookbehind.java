package org.jimkast.exotic.parse.regex;

import java.util.List;
import org.jimkast.exotic.binary.binary;

public final class dir_lookbehind implements dir {
    private final dir d;
    private final dir behind;

    public dir_lookbehind(dir d, dir behind) {
        this.d = d;
        this.behind = behind;
    }

    @Override
    public int test(binary b, int pos, List<binary> groups) {
        int behind_res = behind.test(b, pos, groups);
        return behind_res == -1 ? behind_res : d.test(b, pos + behind_res, groups);
    }
}
