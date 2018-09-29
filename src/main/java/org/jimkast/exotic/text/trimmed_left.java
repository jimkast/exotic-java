package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.numberjdk.Int;
import org.jimkast.exotic.numberjdk.NumSticky;

public final class trimmed_left extends binary.env {
    public trimmed_left(binary origin) {
        super(
            new skipped(
                new NumSticky(
                    new Int() {
                        @Override
                        public int intValue() {
                            int len = origin.length();
                            int k = 0;
                            while (k < len && Character.isWhitespace(origin.at(k))) {
                                k++;
                            }
                            return len - k;
                        }
                    }
                ),
                origin
            )
        );
    }
}
