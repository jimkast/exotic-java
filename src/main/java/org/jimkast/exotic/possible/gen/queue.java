package org.jimkast.exotic.possible.gen;

public interface queue<T> {
    int length();

    queue<T> push(T item);

    T pop();
}
