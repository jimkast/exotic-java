package org.jimkast.ooj.parse.regex;

public final class dir_asterisk extends dir.env {
    public dir_asterisk(dir origin) {
        super(new dir_times(0, Integer.MAX_VALUE, origin));
    }
}
