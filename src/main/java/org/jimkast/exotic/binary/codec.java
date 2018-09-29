package org.jimkast.exotic.binary;

public interface codec {
    binary encode(binary b);

    binary decode(binary b);
}
