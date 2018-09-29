package org.jimkast.exotic.text;

import java.util.function.Consumer;
import org.jimkast.exotic.number.sub;
import org.jimkast.exotic.numberjdk.NumberEnvelope;
import org.jimkast.exotic.possible.possible;
import org.jimkast.exotic.possible.range;

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

    final class chars implements possible<Integer> {
        private final text text;
        private int i = 0;

        public chars(text text) {
            this.text = text;
        }

        @Override
        public void supply(Consumer<? super Integer> consumer) {
            if (i < text.length()) {
                consumer.accept((int) text.at(i++));
            }
        }
    }

    final class indices extends possible.env<Integer> {
        public indices(text text) {
            super(new range(0, new sub(new length(text), 1)));
        }
    }

    final class length extends NumberEnvelope {
        public length(text text) {
            super(text::length);
        }
    }
}
