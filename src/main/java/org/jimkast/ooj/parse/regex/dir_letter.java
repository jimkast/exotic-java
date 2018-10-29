package org.jimkast.ooj.parse.regex;

import java.util.function.IntPredicate;

public final class dir_letter extends dir.env {
    private static final IntPredicate check = Character::isLetter;

    public dir_letter() {
        super(new dir_single(check));
    }
}
