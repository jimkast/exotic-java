package org.jimkast.exotic.binary;

import java.util.Arrays;
import org.jimkast.exotic.text.fixed32;

public final class sorted extends binary.env {
    private static final bconv SORTING = new sorting();

    public sorted(binary origin) {
        super(new bconverted(SORTING, origin));
    }

    public static final class sorting implements bconv {
        @Override
        public binary convert(binary b) {
            int len = b.length();
            int[] buf = new int[len];
            for (int i = 0; i < len; i++) {
                buf[i] = b.map(i);
            }
            Arrays.sort(buf);
            return new fixed32(buf);
        }
    }

}
