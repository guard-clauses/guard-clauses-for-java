package io.github.chrisdostert.guardclauses;

import org.checkerframework.checker.nullness.qual.NonNull;

public class IterableGuard<E>
        extends AbstractIterableGuard<IterableGuard<E>, Iterable<E>, E> {

    public IterableGuard(
            @NonNull String name,
            @NonNull Iterable<E> value
    ) {

        super(
                name,
                IterableGuard.class,
                value
        );

    }
}
