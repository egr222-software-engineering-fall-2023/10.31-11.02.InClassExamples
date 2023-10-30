import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class CupTest {

    @Test
    void testObjectCreation() {
        Cup c = new Cup("Water", 85.0);
        assertEquals("Water", c.getLiquidType());
        assertEquals(85.0, c.getPercentFull(), 0.001);
    }

    @Test
    void testObjectCreationUsingAssertAll() {
        Cup c = new Cup("Water", 85.0);
        assertAll("Test Object Creation",
                () -> assertEquals("Water", c.getLiquidType()),
                () -> assertEquals(85.0, c.getPercentFull(), 0.001)
        );
    }

    @Test
    void testIsEmpty() {
        Cup c = new Cup("Water", 85.0);
        assertFalse(c.isEmpty());
    }

    @Test
    void testSetLiquidTypeToNull() {
        Cup cup = new Cup("Water",85.0);
        cup.setLiquidType(null);
        assertNotNull(cup.getLiquidType());

    }

    @Disabled("Disabled until bug #99 is fixed")
    @Test
    void testExternalLibrary() {
        // pretend to call something that is buggy and not yet complete
        fail();
    }

    @Test
    void testSetPercentFullToInvalidValue() {
        Cup cup = new Cup("Water", 85.0);
        assertThrows(IllegalArgumentException.class,
                () -> cup.setPercentFull(-1)
        );
    }

    @Test
    void testGuessThePercentFull() {
        Cup cup = new Cup("Water", 50.01);
        assertTimeoutPreemptively(
                Duration.ofSeconds(5),
                () -> assertTrue(guessThePercentFull(cup) > 0)
        );

    }

    // a private helper method that uses an indefinite loop to guess the percent full
    // of a cup of water.  If the percent full is guessed within the prescribed tolerance
    // then the guess is returned.
    //
    // The method keeps looping until the guess is within the prescribed tolerance.
    private double guessThePercentFull(Cup cup) {
        while (true) {
            double guess = Math.random();
            if (Math.abs(guess * 100.0 - cup.getPercentFull()) < 0.0001) {
                return guess;
            }
        }
    }
}