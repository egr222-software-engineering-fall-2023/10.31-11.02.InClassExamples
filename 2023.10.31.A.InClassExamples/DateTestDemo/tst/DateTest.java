import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.DateTimeException;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void testAddDaysWithinSameMonth() {
        Date d = new Date(2050, 2, 15);
        d.addDays(4);
        assertEquals(19, d.getDay(), "day when adding 4 days to 2050/2/15");
        assertEquals(2, d.getMonth(), "month when adding 4 days to 2050/2/15");
        assertEquals(2050, d.getYear(), "year when adding 4 days to 2050/2/15");
    }

    @Test
    void testAddDaysWrapToNextMonth() {
        Date d = new Date(2050, 2, 15);
        d.addDays(14);
        assertEquals(1, d.getDay(), "day when adding 14 days to 2050/2/15");
        assertEquals(3, d.getMonth(), "month when adding 14 days to 2050/2/15");
        assertEquals(2050, d.getYear(), "year when adding 14 days to 2050/2/15");
    }

    @Test
    void testAddDaysWithinSameMonthUsingAssertAll() {
        Date d = new Date(2050, 2, 15);
        d.addDays(4);
        assertAll("adding 4 days to 2050/2/15",
                () -> assertEquals(20, d.getDay(), "day"),
                () -> assertEquals(3, d.getMonth(), "month"),
                () -> assertEquals(2050, d.getYear(), "year")
        );
    }

    @Test
    void testAddDaysWithinSameMonthUsingExpected() {
        addHelper(2050, 2, 15, 4, 2050, 2, 19);
    }

    @Test
    void testAddDaysWrapToNextMonthUsingExpected() {
        addHelper(2050, 2, 15, 14, 2050, 3, 1);
    }

    @Test
    void testAddDaysWrapToNextYearUsingExpected() {
        addHelper(2050, 12, 15, +17, 2051, 1, 1);
    }

    private void addHelper(int y1, int m1, int d1, int add,
                           int y2, int m2, int d2) {
        Date d = new Date(y1, m1, d1);
        d.addDays(add);
        Date expected = new Date(y2, m2, d2);
        assertEquals(expected, d, "adding " + add + " days");
    }

    @Test
    @Timeout(5)
    public void constructInvalidDateInFebruaryNonLeapYear() {
        assertThrows(DateTimeException.class,
                () -> new Date(2021, 2, 29)
        );
    }

}