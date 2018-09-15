package org.jimkast.exotic.text;

import org.jimkast.exotic.bool.bool;
import org.jimkast.exotic.bool.gte;

public final class contains extends bool.env {
    public contains(text source, text target) {
        super(new gte(new indexof(source, target), 0));
    }
}
