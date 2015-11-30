package io.github.chrisdostert.guardclauses;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.stream.StreamSupport;

/**
 * @param <T> the "self" type of this assertion class. Please read &quot;<a href="http://bit.ly/1IZIRcY"
 *            target="_blank">Emulating 'self types' using Java Generics to simplify fluent API implementation</a>&quot;
 *            for more details.
 * @param <P> the type of the parameter.
 * @param <E> the type of the elements of the parameter
 */
public abstract class AbstractIterableGuard<T extends AbstractIterableGuard<T, P, E>, P extends Iterable<E>, E>
        extends AbstractObjectGuard<T, P> {

    /*
    constructors
     */
    protected AbstractIterableGuard(
            String name,
            Class<?> typeOfThis,
            P value
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
    public T hasCountGreaterThan(
            @NonNull Long tooSmall
    ) {

        if (null == tooSmall) {

            throw new IllegalArgumentException(
                    "tooSmall cannot be null"
            );

        }

        if (
                StreamSupport
                        .stream(parameterValue.spliterator(), false)
                        .count()
                        <=
                        tooSmall
                ) {

            throw new IllegalArgumentException(
                    String.format(
                            "count of %s must be greater than %s",
                            parameterName,
                            tooSmall
                    )
            );

        }

        return thisTyped;

    }

    public T hasCountLessThan(
            @NonNull Long tooBig
    ) {

        if (null == tooBig) {

            throw new IllegalArgumentException(
                    "tooBig cannot be null"
            );

        }

        if (
                StreamSupport
                        .stream(parameterValue.spliterator(), false)
                        .count()
                        >=
                        tooBig
                ) {

            throw new IllegalArgumentException(
                    String.format(
                            "count of %s must be less than %s",
                            parameterName,
                            tooBig
                    )
            );

        }

        return thisTyped;

    }

}
