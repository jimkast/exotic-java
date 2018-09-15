package org.jimkast.exotic.text;

public final class uppercase extends text.env {
    public uppercase(text origin) {
        super(new mapped(Character::toUpperCase, origin));
    }
}
