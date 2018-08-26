package org.jimkast.exotic.bool;

import java.util.function.Supplier;

public interface cond {
    <T> T choose(T left, T right);

    cond TRUE = new btrue();
    cond FALSE = new bfalse();


    class env implements cond {
        private final cond origin;

        public env(cond origin) {
            this.origin = origin;
        }

        @Override
        public final <T> T choose(T left, T right) {
            return origin.choose(left, right);
        }
    }

    final class ofbool implements cond {
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


    final class bfalse implements cond {
        @Override
        public <T> T choose(T left, T right) {
            return right;
        }
    }


    final class btrue implements cond {
        @Override
        public <T> T choose(T left, T right) {
            return left;
        }
    }


    final class AsBool {
        private final org.jimkast.exotic.bool.cond cond;

        public AsBool(org.jimkast.exotic.bool.cond cond) {
            this.cond = cond;
        }

        public boolean value() {
            return cond.choose(true, false);
        }
    }
}
