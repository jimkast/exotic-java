package org.jimkast.exotic.xml.v3;

import org.jimkast.exotic.binary.binary;

public interface Target {
    void accept(binary alpha, binary beta, int type);
}
