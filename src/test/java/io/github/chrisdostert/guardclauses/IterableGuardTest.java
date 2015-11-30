package io.github.chrisdostert.guardclauses;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.StrictAssertions.assertThatThrownBy;

public class IterableGuardTest {

    /*
    fields
     */
    private final Dummy dummy = new Dummy();

    /*
    test methods
     */
    @Test
    public void hasCountGreaterThan_WhenTrue_DoesNotThrow() {

        /*
        arrange
         */
        Long tooSmall = 1L;

        Iterable<String> iterableWithCountGreaterThanTooSmall =
                Lists.newArrayList(
                        dummy.getString(),
                        dummy.getString()
                );

        IterableGuard<String> objectUnderTest =
                new IterableGuard<>(
                        dummy.getString(),
                        iterableWithCountGreaterThanTooSmall
                );

        /*
        act
         */
        objectUnderTest
                .hasCountGreaterThan(
                        tooSmall
                );
    }

    @Test
    public void hasCountGreaterThan_WhenFalse_Throws() {

        /*
        arrange
         */
        Long tooSmall = 1L;

        Iterable<String> iterableWithCountTooSmall =
                Lists.newArrayList(
                        dummy.getString()
                );

        IterableGuard<String> objectUnderTest =
                new IterableGuard<>(
                        dummy.getString(),
                        iterableWithCountTooSmall
                );

        /*
        act
         */
        assertThatThrownBy(() ->
                objectUnderTest
                        .hasCountGreaterThan(
                                tooSmall
                        )
        );
    }

    @Test
    public void hasCountLessThan_WhenTrue_DoesNotThrow() {

        /*
        arrange
         */
        Long tooBig = 2L;

        Iterable<String> iterableWithCountLessThanTooBig =
                Lists.newArrayList(
                        dummy.getString()
                );

        IterableGuard<String> objectUnderTest =
                new IterableGuard<>(
                        dummy.getString(),
                        iterableWithCountLessThanTooBig
                );

        /*
        act
         */
        objectUnderTest
                .hasCountLessThan(
                        tooBig
                );

    }

    @Test
    public void hasCountLessThan_WhenFalse_Throws() {

        /*
        arrange
         */
        Long tooBig = 2L;

        Iterable<String> iterableWithCountTooBig =
                Lists.newArrayList(
                        dummy.getString(),
                        dummy.getString()
                );

        IterableGuard<String> objectUnderTest =
                new IterableGuard<>(
                        dummy.getString(),
                        iterableWithCountTooBig
                );

        /*
        act
         */
        assertThatThrownBy(() ->
                objectUnderTest
                        .hasCountLessThan(
                                tooBig
                        )
        );

    }

    @Test
    public void isNotNull_WhenTrue_DoesNotThrow() {

        /*
        arrange
         */
        IterableGuard<String> objectUnderTest =
                new IterableGuard<>(
                        dummy.getString(),
                        new ArrayList<>()
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
        IterableGuard objectUnderTest =
                new IterableGuard(
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
    public void thenGetValue() {

        /*
        arrange
         */
        Iterable<String> expectedIterable =
                new ArrayList<>();

        IterableGuard<String> objectUnderTest =
                new IterableGuard<>(
                        dummy.getString(),
                        expectedIterable
                );

        /*
        act
         */
        Iterable actualValue = objectUnderTest.thenGetValue();

        /*
        assert
         */
        assertThat(actualValue)
                .isEqualTo(expectedIterable);

    }
}