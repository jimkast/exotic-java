package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.binary.mapped;

public final class lowercase extends binary.env {
    public lowercase(binary origin) {
        super(new mapped(Character::toLowerCase, origin));
    }
}
