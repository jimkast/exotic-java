package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;

public final class of_charseq implements binary {
    private final CharSequence seq;

    public of_charseq(CharSequence seq) {
        this.seq = seq;
    }

    @Override
    public int at(int i) {
        return seq.charAt(i);
    }

    @Override
    public int length() {
        return seq.length();
    }
}
