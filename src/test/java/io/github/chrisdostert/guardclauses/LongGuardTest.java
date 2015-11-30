package io.github.chrisdostert.guardclauses;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.StrictAssertions.assertThatThrownBy;

public class LongGuardTest {

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
        Long tooSmall = 10L;

        Long parameterValueBiggerThanTooSmall = tooSmall + 1;

        LongGuard objectUnderTest =
                new LongGuard(
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
        Long tooSmall = 10L;

        Long parameterValueSmallerThanTooSmall = tooSmall - 1;

        LongGuard objectUnderTest =
                new LongGuard(
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
        Long tooBig = 10L;

        Long parameterValueSmallerThanTooBig = tooBig - 1;

        LongGuard objectUnderTest =
                new LongGuard(
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
        Long tooBig = 10L;

        Long parameterValueBiggerThanTooBig = tooBig + 1;

        LongGuard objectUnderTest =
                new LongGuard(
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
        LongGuard objectUnderTest =
                new LongGuard(
                        dummy.getString(),
                        dummy.getLong()
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
        LongGuard objectUnderTest =
                new LongGuard(
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
        Long expectedValue = dummy.getLong();

        LongGuard objectUnderTest =
                new LongGuard(
                        dummy.getString(),
                        expectedValue
                );

        /*
        act
         */
        Long actualValue =
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