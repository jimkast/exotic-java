package org.jimkast.exotic.io.bs;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public final class BsFile implements BytesSource {
    private final Path file;

    public BsFile(File file) {
        this(file.toPath());
    }

    public BsFile(Path file) {
        this.file = file;
    }

    @Override
    public void print(OutputStream out) throws IOException {
        Files.copy(file, out);
    }
}
