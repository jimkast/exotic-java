package org.jimkast.exotic.bool;

public interface check<T> {
    cond test(T o);

    check<?> VALID = (check<Object>) o -> cond.TRUE;
    check<?> INVALID = (check<Object>) o -> cond.FALSE;

    @SuppressWarnings("unchecked")
    static <T> check<T> valid() {
        return (check<T>) VALID;
    }

    @SuppressWarnings("unchecked")
    static <T> check<T> invalid() {
        return (check<T>) INVALID;
    }
}
