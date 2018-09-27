package org.jimkast.exotic.map;

import org.jimkast.exotic.data.binary;
import org.jimkast.exotic.possible.possible;

public interface possible1<T> {
    possible<T> map(binary key);
}
