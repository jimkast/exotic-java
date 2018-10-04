package org.jimkast.exotic.parse.regex;

import java.util.List;
import org.jimkast.exotic.binary.binary;

public final class dir_dot implements dir {
    @Override
    public int test(binary b, int pos, List<binary> groups) {
        return pos < b.length() ? 1 : -1;
    }
}
