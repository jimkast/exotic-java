package org.jimkast.ooj.parse.regex;

import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.text.of_charseq;
import org.jimkast.ooj.lang.ArrayTarget;
import org.jimkast.ooj.lang.Binary;

public final class dir_str_any implements dir {
    private final binary str;

    public dir_str_any(CharSequence str) {
        this(new of_charseq(str));
    }

    public dir_str_any(binary str) {
        this.str = str;
    }

    @Override
    public int test(Binary b, int pos, ArrayTarget<binary> groups) {
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (b.map(pos) == str.map(i)) {
                return 1;
            }
        }
        return -1;
    }
}
