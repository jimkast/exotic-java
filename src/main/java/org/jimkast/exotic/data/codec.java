package org.jimkast.exotic.data;

public interface codec {
    binary encode(binary b);

    binary decode(binary b);
}
