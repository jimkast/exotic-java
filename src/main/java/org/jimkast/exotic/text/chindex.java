package org.jimkast.exotic.text;

import org.jimkast.exotic.numberjdk.Int;

public final class chindex extends Int  {
    private final text t1;
    private final char ch;

    public chindex(text t1, char ch) {
        this.t1 = t1;
        this.ch = ch;
    }

    @Override
    public int intValue() {
        int len = t1.length();
        for (int i = 0; i < len; i++) {
            if (t1.at(i) == ch) {
                return i;
            }
        }
        return -1;
    }
}
