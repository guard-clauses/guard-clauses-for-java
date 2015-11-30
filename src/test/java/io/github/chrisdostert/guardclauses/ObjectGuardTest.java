package io.github.chrisdostert.guardclauses;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.StrictAssertions.assertThatThrownBy;

public class ObjectGuardTest {

    /*
    fields
     */
    private final Dummy dummy = new Dummy();

    /*
    test methods
     */
    @Test
    public void isNotNull_WhenTrue_DoesNotThrow(
    ) {

        /*
        arrange
         */
        ObjectGuard objectUnderTest = new ObjectGuard(
                dummy.getString(),
                dummy.getObject()
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
        ObjectGuard objectUnderTest = new ObjectGuard(
                dummy.getString(),
                null
        );

        /*
        act/assert
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

        Object expectedValue = dummy.getString();

        ObjectGuard objectUnderTest =
                new ObjectGuard(
                        dummy.getString(),
                        expectedValue
                );

        /*
        act
         */
        Object actualValue =
                objectUnderTest.thenGetValue();

        /*
        assert
         */
        assertThat(actualValue)
                .isEqualTo(expectedValue);

    }

}