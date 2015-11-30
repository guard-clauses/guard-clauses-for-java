package io.github.chrisdostert.guardclauses;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.StrictAssertions.assertThatThrownBy;

public class StringGuardTest {

    /*
    fields
     */
    private final Dummy dummy = new Dummy();

    /*
    test methods
     */
    @Test
    public void hasCharacterLengthEqualTo_WhenTrue_DoesNotThrow(
    ) {

        /*
        arrange
         */
        Integer requiredLength = 40;

        char[] charArrayThatIsRequiredLength = new char[requiredLength];

        Arrays.fill(charArrayThatIsRequiredLength, '*');

        StringGuard objectUnderTest =
                new StringGuard(
                        dummy.getString(),
                        new String(
                                charArrayThatIsRequiredLength
                        )
                );

        /*
        act
         */
        objectUnderTest
                .hasCharacterLengthEqualTo(
                        requiredLength
                );

    }

    @Test
    public void hasCharacterLengthEqualTo_WhenFalse_Throws(
    ) {

        /*
        arrange
         */
        Integer requiredLength = 40;

        char[] charArrayThatIsNotRequiredLength = new char[requiredLength + 1];

        Arrays.fill(charArrayThatIsNotRequiredLength, '*');

        StringGuard objectUnderTest =
                new StringGuard(
                        dummy.getString(),
                        new String(
                                charArrayThatIsNotRequiredLength
                        )
                );

        /*
        act
         */
        assertThatThrownBy(() ->
                objectUnderTest
                        .hasCharacterLengthEqualTo(
                                requiredLength
                        )
        );

    }

    @Test
    public void hasCharacterLengthGreaterThan_WhenTrue_DoesNotThrow(
    ) {

        /*
        arrange
         */
        Integer tooShort = 40;

        char[] charArrayThatIsNotTooShort = new char[tooShort + 1];

        Arrays.fill(charArrayThatIsNotTooShort, '*');

        StringGuard objectUnderTest =
                new StringGuard(
                        dummy.getString(),
                        new String(
                                charArrayThatIsNotTooShort
                        )
                );

        /*
        act
         */
        objectUnderTest
                .hasCharacterLengthGreaterThan(
                        tooShort
                );

    }

    @Test
    public void hasCharacterLengthGreaterThan_WhenFalse_Throws(
    ) {

        /*
        arrange
         */
        Integer tooShort = 40;

        char[] charArrayThatIsTooShort = new char[tooShort];

        Arrays.fill(charArrayThatIsTooShort, '*');

        StringGuard objectUnderTest =
                new StringGuard(
                        dummy.getString(),
                        new String(
                                charArrayThatIsTooShort
                        )
                );

        /*
        act/assert
         */
        assertThatThrownBy(() ->
                objectUnderTest
                        .hasCharacterLengthGreaterThan(
                                tooShort
                        )
        );

    }

    @Test
    public void hasCharacterLengthLessThan_WhenTrue_DoesNotThrow(
    ) {

        /*
        arrange
         */
        Integer tooLong = 40;

        char[] charArrayThatIsNotTooLong = new char[tooLong - 1];

        Arrays.fill(charArrayThatIsNotTooLong, '*');

        StringGuard objectUnderTest =
                new StringGuard(
                        dummy.getString(),
                        new String(
                                charArrayThatIsNotTooLong
                        )
                );

        /*
        act
         */
        objectUnderTest
                .hasCharacterLengthLessThan(
                        tooLong
                );

    }

    @Test
    public void hasCharacterLengthLessThan_WhenFalse_Throws(
    ) {

        /*
        arrange
         */
        Integer tooLong = 40;

        char[] charArrayThatIsTooLong = new char[tooLong];

        Arrays.fill(charArrayThatIsTooLong, '*');

        StringGuard objectUnderTest =
                new StringGuard(
                        dummy.getString(),
                        new String(
                                charArrayThatIsTooLong
                        )
                );

        /*
        act/assert
         */
        assertThatThrownBy(() ->
                objectUnderTest
                        .hasCharacterLengthLessThan(
                                tooLong
                        )
        );

    }

    @Test
    public void matches_WhenTrue_DoesNotThrow(
    ) {

        /*
        arrange
         */
        String regex = "apple";

        String parameterValue = "apple";

        StringGuard objectUnderTest =
                new StringGuard(
                        dummy.getString(),
                        parameterValue
                );

        /*
        act
         */
        objectUnderTest
                .matches(
                        regex
                );

    }

    @Test
    public void matches_WhenFalse_Throws(
    ) {

        /*
        arrange
         */
        String regex = "apple";

        String parameterValue = "orange";

        StringGuard objectUnderTest =
                new StringGuard(
                        dummy.getString(),
                        parameterValue
                );

        /*
        act/assert
         */
        assertThatThrownBy(() ->
                objectUnderTest
                        .matches(
                                regex
                        )
        );

    }

    @Test
    public void isNotNull_WhenTrue_DoesNotThrow(
    ) {

        /*
        arrange
         */
        StringGuard objectUnderTest =
                new StringGuard(
                        dummy.getString(),
                        dummy.getString()
                );

        /*
        act
         */
        objectUnderTest.isNotNull();

    }

    @Test
    public void isNotNull_WhenFalse_Throws(
    ) {

        /*
        arrange
         */
        StringGuard objectUnderTest =
                new StringGuard(
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
    public void thenGetValue_ReturnsExpectedValue(
    ) {

        /*
        arrange
         */
        String expectedValue = "apple";

        StringGuard objectUnderTest =
                new StringGuard(
                        dummy.getString(),
                        expectedValue
                );

        /*
        act
         */
        String actualValue =
                objectUnderTest
                        .thenGetValue();

        /*
        assert
         */
        assertThat(actualValue)
                .isEqualTo(expectedValue);

    }
}