package org.jimkast.ooj.parse.regex;

import java.util.ArrayList;
import java.util.List;
import org.jimkast.exotic.binary.binary;
import org.jimkast.ooj.lang.ArrayTarget;
import org.jimkast.ooj.lang.Binary;

public final class fluent implements dir {
    private final List<dir> dirs;

    public fluent() {
        this(new ArrayList<>());
    }

    public fluent(List<dir> dirs) {
        this.dirs = dirs;
    }

    public fluent fixed(int ch) {
        dirs.add(new dir_single_fixed(ch));
        return this;
    }

    public fluent fixed(CharSequence str) {
        dirs.add(new dir_str(str));
        return this;
    }

    @Override
    public int test(Binary b, int pos, ArrayTarget<binary> groups) {
        return new dir_sequence(dirs).test(b, pos, groups);
    }
}
