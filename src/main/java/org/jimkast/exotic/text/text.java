package org.jimkast.exotic.text;

public interface text {
    char at(int i);

    int length();


    class env implements text {
        private final text origin;

        public env(text origin) {
            this.origin = origin;
        }

        @Override
        public char at(int i) {
            return origin.at(i);
        }

        @Override
        public int length() {
            return origin.length();
        }
    }


    final class of implements text {
        private final CharSequence seq;

        public of(CharSequence seq) {
            this.seq = seq;
        }

        @Override
        public char at(int i) {
            return seq.charAt(i);
        }

        @Override
        public int length() {
            return seq.length();
        }
    }


    final class as_charseq implements CharSequence {
        private final text text;

        public as_charseq(text text) {
            this.text = text;
        }

        @Override
        public int length() {
            return text.length();
        }

        @Override
        public char charAt(int index) {
            return text.at(index);
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            return new as_charseq(new substring(text, start, end));
        }
    }
}
