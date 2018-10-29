package org.jimkast.ooj.parse.regex;

import org.jimkast.exotic.binary.binary;
import org.jimkast.ooj.lang.ArrayTarget;
import org.jimkast.ooj.lang.Binary;

public final class dir_word_boundary implements dir {
    @Override
    public int test(Binary b, int pos, ArrayTarget<binary> groups) {
        return pos == 0 || Character.isLetter(b.map(pos - 1)) != Character.isLetter(b.map(1)) || b.length() == pos ? 0 : -1;
    }
}
