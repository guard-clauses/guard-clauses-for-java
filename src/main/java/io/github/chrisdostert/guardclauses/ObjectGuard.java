package io.github.chrisdostert.guardclauses;

import org.checkerframework.checker.nullness.qual.NonNull;

public class ObjectGuard<P>
        extends AbstractObjectGuard<ObjectGuard<P>, P> {

    public ObjectGuard(
            @NonNull String name,
            @NonNull P value
    ) {

        super(
                name,
                ObjectGuard.class,
                value
        );

    }
}
