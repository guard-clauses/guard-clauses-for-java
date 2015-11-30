package io.github.chrisdostert.guardclauses;

import org.checkerframework.checker.nullness.qual.NonNull;

public class StringGuard
        extends AbstractObjectGuard<StringGuard, String> {

    public StringGuard(
            @NonNull String name,
            @NonNull String value
    ) {

        super(
                name,
                StringGuard.class,
                value
        );

    }

    public StringGuard hasCharacterLengthEqualTo(
            @NonNull Integer requiredLength
    ) {

        if (null == requiredLength) {

            throw new IllegalArgumentException(
                    "requiredLength cannot be null"
            );

        }

        if (parameterValue.length() != requiredLength) {

            throw new IllegalArgumentException(
                    String.format(
                            "%s must be exactly %s characters",
                            parameterName,
                            requiredLength
                    )
            );

        }

        return this;

    }

    public StringGuard hasCharacterLengthGreaterThan(
            @NonNull Integer tooShort
    ) {

        if (null == tooShort) {

            throw new IllegalArgumentException(
                    "tooShort cannot be null"
            );

        }

        if (parameterValue.length() <= tooShort) {

            throw new IllegalArgumentException(
                    String.format(
                            "%s must be greater than %s characters",
                            parameterName,
                            tooShort
                    )
            );

        }

        return this;

    }

    public StringGuard hasCharacterLengthLessThan(
            @NonNull Integer tooLong
    ) {

        if (null == tooLong) {

            throw new IllegalArgumentException(
                    "tooLong cannot be null"
            );

        }

        if (parameterValue.length() >= tooLong) {

            throw new IllegalArgumentException(
                    String.format(
                            "%s must be less than %s characters",
                            parameterName,
                            tooLong
                    )
            );

        }

        return this;

    }

    public StringGuard matches(
            @NonNull String regex
    ) {

        if (null == regex) {

            throw new IllegalArgumentException(
                    "regex cannot be null"
            );

        }

        if (!parameterValue.matches(regex)) {

            throw new IllegalArgumentException(
                    String.format(
                            "%s must match pattern %s",
                            parameterName,
                            regex
                    )
            );

        }

        return this;

    }
}
