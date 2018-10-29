package org.jimkast.ooj.parse.regex;

import org.jimkast.exotic.binary.binary;
import org.jimkast.ooj.lang.ArrayTarget;
import org.jimkast.ooj.lang.Binary;

public interface dir {
    int test(Binary b, int pos, ArrayTarget<binary> groups);


    class env implements dir {
        private final dir origin;

        public env(dir origin) {
            this.origin = origin;
        }

        @Override
        public final int test(Binary b, int pos, ArrayTarget<binary> groups) {
            return origin.test(b, pos, groups);
        }
    }
}
