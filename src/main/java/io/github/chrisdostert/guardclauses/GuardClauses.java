package io.github.chrisdostert.guardclauses;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Entry point for guard methods for different data types. Each method in this class is a static factory for
 * a data type specific guard object.
 */
public class GuardClauses {

    public static <E> IterableGuard<E> guardThat(
            @NonNull String name,
            @Nullable Iterable<E> value
    ) {

        return new IterableGuard<>(
                name,
                value
        );

    }

    public static IntegerGuard guardThat(
            @NonNull String name,
            @Nullable Integer value
    ) {

        return new IntegerGuard(
                name,
                value
        );

    }

    public static LongGuard guardThat(
            @NonNull String name,
            @Nullable Long value
    ) {

        return new LongGuard(
                name,
                value
        );

    }

    public static <P> ObjectGuard<P> guardThat(
            @NonNull String name,
            @Nullable P value
    ) {

        return new ObjectGuard<>(
                name,
                value
        );

    }

    public static StringGuard guardThat(
            @NonNull String name,
            @Nullable String value
    ) {

        return new StringGuard(
                name,
                value
        );

    }

}
