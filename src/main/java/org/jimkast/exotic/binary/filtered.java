package org.jimkast.exotic.binary;

import org.jimkast.exotic.text.headof;
import org.jimkast.exotic.text.simple;

public final class filtered extends binary.env {
    public filtered(bfilter f, binary origin) {
        super(new bconverted(new filter(f), origin));
    }


    static final class filter implements bconv {
        private final bfilter filter;

        filter(bfilter filter) {
            this.filter = filter;
        }

        @Override
        public binary convert(binary origin) {
            int found = 0;
            int[] buf = new int[]{origin.length()};
            int len = origin.length();
            for (int i = 0; i < len; i++) {
                int b = origin.at(i);
                if (filter.test(b)) {
                    if (found == 0) {
                        buf = new int[]{len - i};
                    }
                    buf[found++] = b;
                }
            }
            return new headof(found, new simple(buf));
        }
    }
}
