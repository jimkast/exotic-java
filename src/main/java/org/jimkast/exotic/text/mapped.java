package org.jimkast.exotic.text;

public final class mapped implements text {
    private final char_mapping mapping;
    private final text origin;

    public mapped(char_mapping mapping, text origin) {
        this.mapping = mapping;
        this.origin = origin;
    }

    @Override
    public char at(int i) {
        return mapping.map(origin.at(i));
    }

    @Override
    public int length() {
        return origin.length();
    }
}
