package org.jimkast.ooj.http;

import org.jimkast.ooj.bisource.BiTarget;
import org.jimkast.ooj.lang.Binary;

public interface HttpTarget extends BiTarget<Binary, Binary> {
    void accept(Binary name, Binary value);
}
