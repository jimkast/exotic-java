package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;

public final class simple_chars implements binary {
    private final char[] ch;

    public simple_chars(char[] ch) {
        this.ch = ch;
    }

    @Override
    public int at(int i) {
        return ch[i];
    }

    @Override
    public int length() {
        return ch.length;
    }
}
