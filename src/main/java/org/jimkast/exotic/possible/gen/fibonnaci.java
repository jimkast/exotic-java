package org.jimkast.exotic.possible.gen;

import org.jimkast.exotic.number.add;
import org.jimkast.exotic.numberjdk.NumberEnvelope;

public final class fibonnaci extends NumberEnvelope {
    public fibonnaci() {
        super(new gen2<>(0, 1, add::new));
    }
}
