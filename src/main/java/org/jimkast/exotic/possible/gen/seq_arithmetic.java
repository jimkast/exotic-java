package org.jimkast.exotic.possible.gen;

import org.jimkast.exotic.number.add;
import org.jimkast.exotic.numberjdk.NumberEnvelope;

public final class seq_arithmetic extends NumberEnvelope {
    public seq_arithmetic() {
        this(0);
    }

    public seq_arithmetic(Number from) {
        this(from, 1);
    }

    public seq_arithmetic(Number from, Number step) {
        super(new gen1<>(from, i -> new add(i, step)));
    }
}
