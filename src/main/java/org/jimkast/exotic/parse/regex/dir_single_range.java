package org.jimkast.exotic.parse.regex;

public final class dir_single_range extends dir.env {
    public dir_single_range(int from, int to) {
        super(new dir_single(val -> val >= from && val <= to));
    }
}
