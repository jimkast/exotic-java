package org.jimkast.exotic.io.bs;

import org.cactoos.io.InputOf;
import org.jimkast.exotic.io.BytesSticky;

public final class bs_sticky extends bsource.env {
    public bs_sticky(bsource origin) {
        super(
            new bs_input(
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
