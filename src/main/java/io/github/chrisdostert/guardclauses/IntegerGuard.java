package io.github.chrisdostert.guardclauses;

import org.checkerframework.checker.nullness.qual.NonNull;

public class IntegerGuard
        extends AbstractComparableGuard<IntegerGuard, Integer> {

    public IntegerGuard(
            @NonNull String name,
            @NonNull Integer value
    ) {

        super(
                name,
                IntegerGuard.class,
                value
        );

    }

}
