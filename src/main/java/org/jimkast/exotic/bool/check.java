package org.jimkast.exotic.bool;

public interface check<T> {
    bool test(T o);

    check<?> VALID = (check<Object>) o -> bool.TRUE;
    check<?> INVALID = (check<Object>) o -> bool.FALSE;

    @SuppressWarnings("unchecked")
    static <T> check<T> valid() {
        return (check<T>) VALID;
    }

    @SuppressWarnings("unchecked")
    static <T> check<T> invalid() {
        return (check<T>) INVALID;
    }

    final class not<T> implements check<T> {
        private final check<T> origin;

        public not(check<T> origin) {
            this.origin = origin;
        }

        @Override
        public bool test(T o) {
            return new org.jimkast.exotic.bool.not(origin.test(o));
        }
    }
}
