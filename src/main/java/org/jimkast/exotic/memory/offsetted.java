package org.jimkast.exotic.memory;

public final class offsetted implements memblockR {
    private final Number offset;
    private final memblockR origin;

    public offsetted(Number offset, memblockR origin) {
        this.offset = offset;
        this.origin = origin;
    }

    @Override
    public Number at(Number i) {
        return origin.at(i.intValue() + offset.intValue());
    }

    @Override
    public Number length() {
        return origin.length().intValue() - offset.intValue();
    }

    @Override
    public addr address() {
        addr a = origin.address();
        return new addr(a.arr, a.offset + offset.intValue());
    }
}
