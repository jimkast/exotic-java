package org.jimkast.exotic.heap;

public interface HeapBlock extends Countable {
    HeapAddr address();

    @Override
    int length();
}
