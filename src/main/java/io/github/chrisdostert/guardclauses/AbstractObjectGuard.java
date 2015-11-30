package io.github.chrisdostert.guardclauses;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Base class for all guards
 *
 * @param <T> the "self" type of this assertion class. Please read &quot;<a href="http://bit.ly/1IZIRcY"
 *            target="_blank">Emulating 'self types' using Java Generics to simplify fluent API implementation</a>&quot;
 *            for more details.
 * @param <P> the type of the parameter.
 */
public abstract class AbstractObjectGuard<T extends AbstractObjectGuard<T, P>, P>
        implements Guard<P> {

    /*
    fields
     */
    protected final String parameterName;

    protected final T thisTyped;

    protected final P parameterValue;

    /*
    constructors
     */
    @SuppressWarnings("unchecked")
    protected AbstractObjectGuard(
            @NonNull String parameterName,
            @NonNull Class<?> typeOfThis,
            @Nullable P parameterValue
    ) {

        if (null == parameterName) {

            throw new IllegalArgumentException(
                    "parameterName cannot be null"
            );

        }
        this.parameterName = parameterName;

        if (null == typeOfThis) {

            throw new IllegalArgumentException(
                    "typeOfThis cannot be null"
            );

        }
        thisTyped = (T) typeOfThis.cast(this);

        this.parameterValue = parameterValue;

    }

    /*
    guard methods
     */
    public T isNotNull() {

        if (null == parameterValue) {

            throw new IllegalArgumentException(
                    String.format(
                            "%s cannot be null",
                            parameterName
                    )
            );

        }

        return thisTyped;

    }

    /*
    parameterValue methods
     */
    public P thenGetValue() {

        return parameterValue;

    }

}
