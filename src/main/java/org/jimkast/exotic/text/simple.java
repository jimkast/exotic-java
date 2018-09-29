package org.jimkast.exotic.text;

public final class simple implements binary {
    private final char[] ch;

    public simple(char[] ch) {
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
