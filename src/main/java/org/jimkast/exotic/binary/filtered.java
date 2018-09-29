package org.jimkast.exotic.binary;

public final class filtered implements binary {
    private final bfilter filter;
    private final binary origin;

    public filtered(bfilter filter, binary origin) {
        this.filter = filter;
        this.origin = origin;
    }


    @Override
    public int at(int i) {
        int len = origin.length();
        int found = 0;
        for (int j = 0; j < len && found == i; j++) {
            if (filter.test(origin.at(j))) {
                found++;
            }
        }
        return origin.at(found);
    }

    @Override
    public int length() {
        int len = origin.length();
        int found = 0;
        for (int j = 0; j < len; j++) {
            if (filter.test(origin.at(j))) {
                found++;
            }
        }
        return found;
    }
}
