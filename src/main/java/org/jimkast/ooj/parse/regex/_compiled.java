package org.jimkast.ooj.parse.regex;

import java.util.ArrayList;
import java.util.List;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.text.chindex;
import org.jimkast.exotic.text.headof;
import org.jimkast.exotic.text.skipped;

public final class _compiled {

    public dir compile(binary str) {
        int len = str.length();
        List<dir> dirs = new ArrayList<>();
        for (int i = 0; i < len; i++) {
//            dirs.add(map(str, i, ))
        }
        return new dir_sequence(dirs);
    }

    private dir map(binary b, final int pos, dir prev) {
        int ch = b.map(pos);
        switch (ch) {
            case '+':
                return new dir_plus(prev);
            case '*':
                return new dir_asterisk(prev);
            case '(':
                binary sk = new skipped(pos, b);
                return compile(new headof(new chindex(b, ')'), sk));
            case '{':
                return compile(new skipped(pos, b));
            case '[':
                return compile(new skipped(pos, b));
            case '\\':
                return mapSpecial(b.map(pos + 1));
            default:
                return new dir_single_fixed(ch);

        }
    }

    private dir mapSpecial(int ch) {
        switch (ch) {
            case 's':
                return new dir_whitespace();
            case 'S':
                return new dir_not(new dir_whitespace());
            case 'd':
                return new dir_digit();
            case 'D':
                return new dir_not(new dir_digit());
            case 'w':
                return new dir_letter();
            case 'W':
                return new dir_not(new dir_letter());
            case 'b':
                return new dir_word_boundary();
            case 'B':
                return new dir_not(new dir_word_boundary());
            default:
                return new dir_single_fixed(ch);
        }
    }
}
