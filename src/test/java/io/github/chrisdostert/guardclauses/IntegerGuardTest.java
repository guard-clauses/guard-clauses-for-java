package io.github.chrisdostert.guardclauses;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.StrictAssertions.assertThatThrownBy;

public class IntegerGuardTest {

    /*
    fields
     */
    private final Dummy dummy = new Dummy();

    /*
    test methods
     */
    @Test
    public void isGreaterThan_WhenTrue_DoesNotThrow() {

        /*
        arrange
         */
        Integer tooSmall = 10;

        Integer parameterValueBiggerThanTooSmall = tooSmall + 1;

        IntegerGuard objectUnderTest =
                new IntegerGuard(
                        dummy.getString(),
                        parameterValueBiggerThanTooSmall
                );

        /*
        act
         */
        objectUnderTest
                .isGreaterThan(
                        tooSmall
                );

    }

    @Test
    public void isGreaterThan_WhenFalse_Throws() {

        /*
        arrange
         */
        Integer tooSmall = 10;

        Integer parameterValueSmallerThanTooSmall = tooSmall - 1;

        IntegerGuard objectUnderTest =
                new IntegerGuard(
                        dummy.getString(),
                        parameterValueSmallerThanTooSmall
                );

        /*
        act
         */
        assertThatThrownBy(() ->
                objectUnderTest
                        .isGreaterThan(
                                tooSmall
                        )
        );

    }

    @Test
    public void isLessThan_WhenTrue_DoesNotThrow() {

        /*
        arrange
         */
        Integer tooBig = 10;

        Integer parameterValueSmallerThanTooBig = tooBig - 1;

        IntegerGuard objectUnderTest =
                new IntegerGuard(
                        dummy.getString(),
                        parameterValueSmallerThanTooBig
                );

        /*
        act
         */
        objectUnderTest
                .isLessThan(
                        tooBig
                );

    }

    @Test
    public void isLessThan_WhenFalse_Throws() {

        /*
        arrange
         */
        Integer tooBig = 10;

        Integer parameterValueBiggerThanTooBig = tooBig + 1;

        IntegerGuard objectUnderTest =
                new IntegerGuard(
                        dummy.getString(),
                        parameterValueBiggerThanTooBig
                );

        /*
        act
         */
        assertThatThrownBy(() ->
                objectUnderTest
                        .isLessThan(
                                tooBig
                        )
        );

    }

    @Test
    public void isNotNull_WhenTrue_DoesNotThrow() {

        /*
        arrange
         */
        IntegerGuard objectUnderTest =
                new IntegerGuard(
                        dummy.getString(),
                        dummy.getInteger()
                );

        /*
        act
         */
        objectUnderTest.isNotNull();

    }

    @Test
    public void isNotNull_WhenFalse_Throws() {

        /*
        arrange
         */
        IntegerGuard objectUnderTest =
                new IntegerGuard(
                        dummy.getString(),
                        null
                );

        /*
        act
         */
        assertThatThrownBy(
                objectUnderTest::isNotNull
        );

    }

    @Test
    public void thenGetValue_ReturnsExpectedValue() {

        /*
        arrange
         */
        Integer expectedValue = dummy.getInteger();

        IntegerGuard objectUnderTest =
                new IntegerGuard(
                        dummy.getString(),
                        expectedValue
                );

        /*
        act
         */
        Integer actualValue =
                objectUnderTest
                        .thenGetValue();

        /*
        assert
         */
        assertThat(
                actualValue
        ).isEqualTo(
                expectedValue
        );

    }
}