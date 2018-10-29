package org.jimkast.ooj.parse.regex;

public final class dir_plus extends dir.env {
    public dir_plus(dir origin) {
        super(new dir_times(1, Integer.MAX_VALUE, origin));
    }
}
