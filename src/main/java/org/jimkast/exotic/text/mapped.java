package org.jimkast.exotic.text;

public final class mapped implements binary {
    private final int_mapping mapping;
    private final binary origin;

    public mapped(int_mapping mapping, binary origin) {
        this.mapping = mapping;
        this.origin = origin;
    }

    @Override
    public int at(int i) {
        return mapping.map(origin.at(i));
    }

    @Override
    public int length() {
        return origin.length();
    }
}
