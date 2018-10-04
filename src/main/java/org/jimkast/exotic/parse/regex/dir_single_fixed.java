package org.jimkast.exotic.parse.regex;

public final class dir_single_fixed extends dir.env {
    public dir_single_fixed(int val) {
        super(new dir_single(value -> value == val));
    }
}
