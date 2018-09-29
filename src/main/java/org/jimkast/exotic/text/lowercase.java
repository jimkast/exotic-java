package org.jimkast.exotic.text;

public final class lowercase extends binary.env {
    public lowercase(binary origin) {
        super(new mapped(Character::toLowerCase, origin));
    }
}
