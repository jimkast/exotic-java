package org.jimkast.exotic.text;

import java.util.ArrayList;
import java.util.List;
import org.jimkast.exotic.binary.binary;

public final class cached implements binary {
    private final binary origin;
    private transient final List<binary> val = new ArrayList<>(1);

    public cached(binary origin) {
        this.origin = origin;
    }

    @Override
    public int map(int i) {
        return val().get(0).map(i);
    }

    @Override
    public int length() {
        return val().get(0).length();
    }

    private List<binary> val() {
        if (val.isEmpty()) {
            val.add(new fixed16(chars()));
        }
        return val;
    }

    public char[] chars() {
        int len = origin.length();
        char[] buf = new char[len];
        for (int i = 0; i < len; i++) {
            buf[i] = (char) origin.map(i);
        }
        return buf;
    }
}
