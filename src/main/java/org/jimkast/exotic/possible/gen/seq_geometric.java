package org.jimkast.exotic.possible.gen;

import org.jimkast.exotic.numberjdk.NumberEnvelope;

public final class seq_geometric extends NumberEnvelope {
    public seq_geometric(Number from, Number ratio) {
        super(new gen1<>(from, i -> i.doubleValue() * ratio.doubleValue()));
    }
}
