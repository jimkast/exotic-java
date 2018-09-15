package org.jimkast.exotic.text;

import org.jimkast.exotic.numberjdk.Int;

public final class indexof extends Int {
    private final text source;
    private final text target;

    public indexof(text source, text target) {
        this.source = source;
        this.target = target;
    }

    @Override
    public int intValue() {
        int len = source.length();
        int len2 = target.length();
        if (len < len2) {
            return -1;
        }
        if (len2 == 0) {
            return len2;
        }
        char first = target.at(0);
        int max = len - len2;

        int i = 0;
        while (i < max) {
            int index = new chindex(new substring(source, i), first).intValue();
            if (index == -1) {
                return -1;
            }
            i += index;
            if (len - i < len2) {
                return -1;
            }
            int k = 1;
            while (k < len2 && source.at(i + k) == target.at(k)) {
                k++;
            }
            if (k == len2) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
