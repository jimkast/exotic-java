package org.jimkast.exotic.parse.regex;

import java.util.List;
import org.jimkast.exotic.binary.binary;

public final class dir_word_boundary implements dir {
    @Override
    public int test(binary b, int pos, List<binary> groups) {
        return pos == 0 || Character.isLetter(b.at(pos - 1)) ? 0 : -1;
    }
}
