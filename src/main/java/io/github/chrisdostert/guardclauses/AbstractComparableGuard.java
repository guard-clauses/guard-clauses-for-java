package io.github.chrisdostert.guardclauses;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 *
 * @param <T> the "self" type of this assertion class. Please read &quot;<a href="http://bit.ly/1IZIRcY"
 *            target="_blank">Emulating 'self types' using Java Generics to simplify fluent API implementation</a>&quot;
 *            for more details.
 * @param <P> the type of the parameter.
 */
public abstract class AbstractComparableGuard<T extends AbstractComparableGuard<T, P>, P extends Comparable<? super P>>
        extends AbstractObjectGuard<T, P> {

    /*
    constructors
     */
    protected AbstractComparableGuard(
            @NonNull String name,
            @NonNull Class<?> typeOfThis,
            @Nullable P value
    ) {

        super(
                name,
                typeOfThis,
                value
        );

    }

    /*
    guard methods
     */
    public T isGreaterThan(
            @NonNull P tooSmall
    ) {

        if (null == tooSmall) {

            throw new IllegalArgumentException(
                    "tooSmall cannot be null"
            );

        }

        if (parameterValue.compareTo(tooSmall) <= 0) {

            throw new IllegalArgumentException(
                    String.format(
                            "%s must be greater than %s",
                            parameterName,
                            tooSmall
                    )
            );

        }

        return thisTyped;

    }

    public T isLessThan(
            @NonNull P tooBig
    ) {

        if (null == tooBig) {

            throw new IllegalArgumentException(
                    "tooBig cannot be null"
            );

        }

        if (parameterValue.compareTo(tooBig) >= 0) {

            throw new IllegalArgumentException(
                    String.format(
                            "%s must be less than %s",
                            parameterName,
                            tooBig
                    )
            );

        }

        return thisTyped;

    }

}
