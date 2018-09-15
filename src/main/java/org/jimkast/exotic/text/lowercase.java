package org.jimkast.exotic.text;

public final class lowercase extends text.env {
    public lowercase(text origin) {
        super(new mapped(Character::toLowerCase, origin));
    }
}
