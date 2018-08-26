package org.jimkast.exotic.io.bs;

import org.cactoos.io.InputOf;
import org.jimkast.exotic.io.BytesSticky;

public final class BsSticky extends BytesSource.env {
    public BsSticky(BytesSource origin) {
        super(
            new BsInput(
                new InputOf(
                    new BytesSticky(
                        new BsMemoryBytes(
                            origin
                        )
                    )
                )
            )
        );
    }
}
