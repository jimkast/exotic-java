package org.jimkast.exotic.parse.regex;

import java.util.List;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.text.of_charseq;

public final class dir_str_any implements dir {
    private final binary str;

    public dir_str_any(CharSequence str) {
        this(new of_charseq(str));
    }

    public dir_str_any(binary str) {
        this.str = str;
    }

    @Override
    public int test(binary b, int pos, List<binary> groups) {
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (b.at(pos) == str.at(i)) {
                return 1;
            }
        }
        return -1;
    }
}
