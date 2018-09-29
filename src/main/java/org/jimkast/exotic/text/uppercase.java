package org.jimkast.exotic.text;

public final class uppercase extends binary.env {
    public uppercase(binary origin) {
        super(new mapped(Character::toUpperCase, origin));
    }
}
