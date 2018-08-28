package org.jimkast.exotic.number.types;

import java.io.IOException;

public interface input {
    int read(byte b[], int off, int len) throws IOException;
}
