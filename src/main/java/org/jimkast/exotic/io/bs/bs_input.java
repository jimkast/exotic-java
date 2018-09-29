package org.jimkast.exotic.io.bs;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import org.cactoos.Input;
import org.cactoos.io.InputOf;
import org.cactoos.io.LengthOf;
import org.cactoos.io.OutputTo;
import org.cactoos.io.TeeInput;
import org.cactoos.scalar.IoCheckedScalar;

public final class bs_input implements bsource {
    private final Input input;
    private final int size;

    public bs_input(Path path) {
        this(new InputOf(path));
    }

    public bs_input(File file) {
        this(new InputOf(file));
    }

    public bs_input(Input input) {
        this(input, 8192);
    }

    public bs_input(Input input, int size) {
        this.input = input;
        this.size = size;
    }

    @Override
    public void transferTo(OutputStream out) throws IOException {
        new IoCheckedScalar<>(new LengthOf(new TeeInput(input, new OutputTo(out)), size)).value();
    }
}
