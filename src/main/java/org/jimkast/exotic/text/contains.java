package org.jimkast.exotic.text;

import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.bool.bool;
import org.jimkast.exotic.bool.gte;

public final class contains extends bool.env {
    public contains(binary source, binary target) {
        super(new gte(new indexof(source, target), 0));
    }
}
