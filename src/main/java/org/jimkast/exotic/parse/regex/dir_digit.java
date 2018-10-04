package org.jimkast.exotic.parse.regex;

import java.util.function.IntPredicate;

public final class dir_digit extends dir.env {
    private static final IntPredicate check = Character::isDigit;

    public dir_digit() {
        super(new dir_single(check));
    }
}
