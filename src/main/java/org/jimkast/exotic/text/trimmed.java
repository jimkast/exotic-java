package org.jimkast.exotic.text;

public final class trimmed extends text.env {
    public trimmed(text origin) {
        super(new trimmed_right(new trimmed_left(origin)));
    }
}
