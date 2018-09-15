package org.jimkast.exotic.text;

import java.util.ArrayList;
import java.util.List;

public final class cached implements text {
    private final text origin;
    private transient final List<text> val = new ArrayList<>(1);

    public cached(text origin) {
        this.origin = origin;
    }

    @Override
    public char at(int i) {
        return val().get(0).at(i);
    }

    @Override
    public int length() {
        return val().get(0).length();
    }

    private List<text> val() {
        if (val.isEmpty()) {
            val.add(cache(origin));
        }
        return val;
    }

    private static text cache(text origin) {
        int len = origin.length();
        char[] buf = new char[len];
        for (int i = 0; i < len; i++) {
            buf[i] = origin.at(i);
        }
        return new simple(buf);
    }
}
