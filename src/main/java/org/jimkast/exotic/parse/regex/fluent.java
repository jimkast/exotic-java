package org.jimkast.exotic.parse.regex;

import java.util.ArrayList;
import java.util.List;
import org.jimkast.exotic.binary.binary;

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
    public int test(binary b, int pos, List<binary> groups) {
        return new dir_sequence(dirs).test(b, pos, groups);
    }
}
