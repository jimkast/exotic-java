package org.jimkast.exotic.parse.regex;

import java.util.function.IntPredicate;

public final class dir_single_fixed extends dir.env {
    public dir_single_fixed(int val) {
        super(new dir_single(new Eq(val)));
    }

    public final static class Eq implements IntPredicate {
        private final int val;

        public Eq(int val) {
            this.val = val;
        }

        @Override
        public boolean test(int value) {
            return val == value;
        }
    }
}
