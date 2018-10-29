package org.jimkast.ooj.parse.regex;

import java.util.function.IntPredicate;

public final class dir_whitespace extends dir.env {
    private static final IntPredicate check = Character::isWhitespace;

    public dir_whitespace() {
        super(new dir_single(check));
    }
}
