import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class CupTest {
    @Test
    void testObjectCreation() {
        Cup cup = new Cup("Water",85.0);
        assertEquals("Water", cup.getLiquidType());
        assertEquals(85.0, cup.getPercentFull(), 0.001);
    }

    @Test
    void testIsEmpty() {
        Cup cup = new Cup("Water",85.0);
        assertFalse(cup.isEmpty());
    }

    @Test
    void testSetLiquidTypeToNull() {
        Cup cup = new Cup("Water",85.0);
        cup.setLiquidType(null);
        assertNotNull(cup.getLiquidType());

    }

    @Disabled("Disable test until outside team completes update")
    @Test
    void testExternalLibrary() {
        // pretend there's code here from some other team
        fail();
    }

    public double guessThePercentFull(Cup cup) {
        while(true) {
            double guess = Math.random();
            if (Math.abs(guess * 100.0 - cup.getPercentFull()) < 0.0001) {
                return guess;
            }
        }
    }

    @Test
    void testSetBadPercentThrows() {
        Cup cup = new Cup("Water", 75.0);
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
}