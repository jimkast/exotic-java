package org.jimkast.ooj.lang;

public interface Cond {
    <T> T choose(T main, T other);


    Mapping<Boolean, Cond> ADAPTER = new JdkMapping();


    Cond TRUE = new Cond() {
        @Override
        public <T> T choose(T main, T other) {
            return main;
        }
    };

    Cond FALSE = new Cond() {
        @Override
        public <T> T choose(T main, T other) {
            return other;
        }
    };

    final class JdkMapping implements Mapping<Boolean, Cond> {
        @Override
        public Cond map(Boolean key) {
            return key ? TRUE : FALSE;
        }
    }

    final class Jdk implements Cond {
        private final boolean b;

        public Jdk(boolean b) {
            this.b = b;
        }

        @Override
        public <T> T choose(T main, T other) {
            return b ? main : other;
        }
    }
}
