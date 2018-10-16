package org.jimkast.exotic.xml.v3;

import java.util.Enumeration;
import java.util.Iterator;

public final class IterEnumaration<T> implements Enumeration<T> {
    private final Iterator<T> iter;

    public IterEnumaration(Iterator<T> iter) {
        this.iter = iter;
    }

    @Override
    public boolean hasMoreElements() {
        return iter.hasNext();
    }

    @Override
    public T nextElement() {
        return iter.next();
    }
}
