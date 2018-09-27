package org.jimkast.exotic.data;

public final class encoded implements binary {
    private final bconv codec;

    public encoded(bconv codec) {
        this.codec = codec;
    }

    @Override
    public int at(int i) {
        return 0;
    }

    @Override
    public int length() {
        return 0;
    }
}
