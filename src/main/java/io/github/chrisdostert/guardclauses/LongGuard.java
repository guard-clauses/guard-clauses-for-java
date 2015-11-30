package io.github.chrisdostert.guardclauses;

import org.checkerframework.checker.nullness.qual.NonNull;

public class LongGuard
        extends AbstractComparableGuard<LongGuard, Long> {

    public LongGuard(
            @NonNull String name,
            @NonNull Long value
    ) {

        super(
                name,
                LongGuard.class,
                value
        );

    }

}
