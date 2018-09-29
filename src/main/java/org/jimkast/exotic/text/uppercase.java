package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.binary.mapped;

public final class uppercase extends binary.env {
    public uppercase(binary origin) {
        super(new mapped(Character::toUpperCase, origin));
    }
}
