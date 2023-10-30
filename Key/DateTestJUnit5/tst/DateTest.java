import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.DateTimeException;
import java.time.Duration;

class DateTest {

    public static final int SIMPLE_TIMEOUT = 1000;
    public static final int COMPLEX_TIMEOUT = 100;

    @Test
    public void test_addDays_addJustOneDay_1() {
        Date actual = new Date(2050, 2, 15);
        actual.addDays(1);
        Date expected = new Date(2050, 2, 16);
        assertEquals(expected, actual, "adding one day to 2050/2/15");
    }

    @Test
    public void constructInvalidDateInFebruaryNonLeapYear() {
        assertThrows(DateTimeException.class,
                () -> new Date(2021, 2, 29)
        );
    }

    @Test
    public void constructInvalidDateInFebruaryLeapYear() {
        assertThrows(DateTimeException.class,
                () -> new Date(2024, 2, 30)
        );
    }

    @Test
    public void constructInvalidDateAtYearBegin() {
        assertThrows(DateTimeException.class,
                () -> new Date(2024, 1, 0)
        );
    }

    @Test
    @Timeout(SIMPLE_TIMEOUT)
    public void constructInvalidDateAtYearEnd() {
        assertThrows(DateTimeException.class,
                () -> new Date(2024, 12, 32)
        );
    }

    private void addHelper(int y, int m, int d, int add, int y2, int m2, int d2) {
        Date act = new Date(y, m, d);
        act.addDays(add);
        Date exp = new Date(y2, m2, d2);
        assertEquals(exp, act, "after " + add + " days");
    }

    @Test
    public void addDays_withinSameMonth_1() {
        // Given
        addHelper(2050, 2, 14, 3, 2050, 2, 17);
    }

    @Test
    public void addDays_wrapToNextMonthInANonLeapYearMillenium() {
        addHelper(2100, 2, 27, 3, 2100, 3, 2);
    }

    @Test
    public void addDays_wrapToNextMonthInANonLeapYearNonMillenium() {
        addHelper(2049, 2, 27, 3, 2049, 3, 2);
    }

    @Test
    @Timeout(3)
    public void addDays_wrapToNextMonthInALeapYear() {
        addHelper(2052, 2, 27, 3, 2052, 3, 1);
    }

    @Test
    public void repeatNextDayOneBillionTimes() {
        assertTimeoutPreemptively(
                Duration.ofSeconds(5),
                () -> {
                    Date act = new Date();
                    for (int i = 1; i < 1000000000; i++) {
                        act.nextDay();
                    }
                }
        );
    }
}