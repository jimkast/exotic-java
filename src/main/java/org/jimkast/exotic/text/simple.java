package org.jimkast.exotic.text;

public final class simple implements text {
    private final char[] ch;

    public simple(char[] ch) {
        this.ch = ch;
    }

    @Override
    public char at(int i) {
        return ch[i];
    }

    @Override
    public int length() {
        return ch.length;
    }
}
