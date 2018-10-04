package org.jimkast.exotic.parse.regex;

import java.util.List;
import org.jimkast.exotic.binary.binary;

public interface dir {
    int test(binary b, int pos, List<binary> groups);


    class env implements dir {
        private final dir origin;

        public env(dir origin) {
            this.origin = origin;
        }

        @Override
        public final int test(binary b, int pos, List<binary> groups) {
            return origin.test(b, pos, groups);
        }
    }
}
