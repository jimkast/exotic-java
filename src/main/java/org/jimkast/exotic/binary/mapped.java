package org.jimkast.exotic.binary;

public final class mapped implements binary {
    private final bmapping mapping;
    private final binary origin;

    public mapped(bmapping mapping, binary origin) {
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
