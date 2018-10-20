package org.jimkast.exotic.string;

public interface Countable {
    int length();

    final class Sum implements Countable {
        private final Iterable<? extends Countable> all;

        public Sum(Iterable<? extends Countable> all) {
            this.all = all;
        }

        @Override
        public int length() {
            int count = 0;
            for (Countable s : all) {
                count += s.length();
            }
            return count;
        }
    }
}
