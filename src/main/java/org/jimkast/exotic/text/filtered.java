package org.jimkast.exotic.text;

public final class filtered implements text {
    private final char_filter filter;
    private final text origin;

    public filtered(char_filter filter, text origin) {
        this.filter = filter;
        this.origin = origin;
    }


    @Override
    public char at(int i) {
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
