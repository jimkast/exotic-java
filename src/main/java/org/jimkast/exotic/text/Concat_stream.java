package org.jimkast.exotic.text;

import java.util.Arrays;
import org.cactoos.iterator.Mapped;
import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.binary.bstream;
import org.jimkast.exotic.binary.bstreamable;

public final class Concat_stream implements bstreamable {
    private final Iterable<binary> all;

    public Concat_stream(binary... all) {
        this(Arrays.asList(all));
    }

    public Concat_stream(Iterable<binary> all) {
        this.all = all;
    }

    @Override
    public bstream stream() {
        return new bstream.All(new Mapped<>(as_bytestream::new, all.iterator()));
    }
}
