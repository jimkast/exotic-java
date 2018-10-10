package org.jimkast.exotic.parse.regex;

public interface match {
    int start();

    int length();

    final class Simple implements match {
        private final int start;
        private final int length;

        public Simple(int start, int length) {
            this.start = start;
            this.length = length;
        }

        @Override
        public int start() {
            return start;
        }

        @Override
        public int length() {
            return length;
        }
    }
}
