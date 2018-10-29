package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;

public final class fixed16 implements binary {
    private final char[] ch;

    public fixed16(char[] ch) {
        this.ch = ch;
    }

    @Override
    public int map(int i) {
        return ch[i];
    }

    @Override
    public int length() {
        return ch.length;
    }
}
