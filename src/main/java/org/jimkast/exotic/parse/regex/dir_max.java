package org.jimkast.exotic.parse.regex;

public final class dir_max extends dir.env {
    public dir_max(int max, dir origin) {
        super(new dir_times(0, max, origin));
    }
}
