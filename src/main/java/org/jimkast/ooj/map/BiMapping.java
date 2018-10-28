package org.jimkast.ooj.map;

public interface BiMapping<X, Y, Z> {
    Z map(X x, Y y);
}
