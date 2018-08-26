package org.jimkast.exotic.loop;

import java.util.function.Consumer;

public interface loop<T> {
    void foreach(Consumer<T> consumer);
}
