package org.jimkast.exotic.bool;

import java.util.function.Supplier;

public interface bool {
    <T> T choose(T left, T right);

    bool TRUE = new btrue();
    bool FALSE = new bfalse();


    class env implements bool {
        private final bool origin;

        public env(bool origin) {
            this.origin = origin;
        }

        @Override
        public final <T> T choose(T left, T right) {
            return origin.choose(left, right);
        }
    }

    final class ofbool implements org.jimkast.exotic.bool.bool {
        private final Supplier<Boolean> bool;

        public ofbool(boolean bool) {
            this(() -> bool);
        }

        public ofbool(Supplier<Boolean> bool) {
            this.bool = bool;
        }

        @Override
        public <T> T choose(T left, T right) {
            return bool.get() ? left : right;
        }
    }


    final class bfalse implements bool {
        @Override
        public <T> T choose(T left, T right) {
            return right;
        }
    }


    final class btrue implements bool {
        @Override
        public <T> T choose(T left, T right) {
            return left;
        }
    }


    final class AsBool {
        private final bool cond;

        public AsBool(bool cond) {
            this.cond = cond;
        }

        public boolean value() {
            return cond.choose(true, false);
        }
    }
}
