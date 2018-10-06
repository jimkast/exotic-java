package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;

public final class fixed8 implements binary {
    private final byte[] ch;

    public fixed8(byte[] ch) {
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
