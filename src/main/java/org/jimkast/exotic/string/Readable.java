package org.jimkast.exotic.string;

public interface Readable {
    int at(int i);

    int length();

    Readable slice(int offset, int length);

    void transferTo(Writeable out);
}
