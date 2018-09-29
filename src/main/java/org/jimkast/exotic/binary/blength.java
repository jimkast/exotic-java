package org.jimkast.exotic.binary;

import org.jimkast.exotic.numberjdk.NumberEnvelope;

public final class blength extends NumberEnvelope {
    public blength(binary text) {
        super(text::length);
    }
}
