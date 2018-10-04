package org.jimkast.exotic.memory;

public interface binaryW {
    void write(Number i, Number content);

    void writeFrom(Number srcOff, memblockR a, Number destOff, Number length);

    Number length();
}
