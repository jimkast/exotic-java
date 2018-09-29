package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;

public final class as_charseq implements CharSequence {
    private final binary text;

    public as_charseq(binary text) {
        this.text = text;
    }

    @Override
    public int length() {
        return text.length();
    }

    @Override
    public char charAt(int index) {
        return (char) text.at(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new as_charseq(new substring(text, start, end));
    }
}
