import org.junit.jupiter.api.Test;

import java.time.DateTimeException;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void testAddDaysWithinSameMonth() {
        Date d = new Date(2050, 2, 15);
        d.addDays(4);
        assertAll("Add 4 days to 2/215/2050",
                () -> assertEquals(19, d.getDay(), "day after adding 4 days to 2/15/2050"),
                () -> assertEquals(2, d.getMonth(), "month after adding 4 days to 2/15/2050"),
                () -> assertEquals(2050, d.getYear(), "year after adding 4 days to 2/15/2050")
        );
    }

    @Test
    void testAddDaysWithinSameMonthUsingExpected() {
        Date d = new Date(2050, 2, 15);
        d.addDays(4);
        Date expected = new Date(2050, 2, 19);
        assertEquals(expected, d);
    }

    @Test
    void testAddDaysWrapToNextMonth() {
        Date d = new Date(2050, 2, 15);
        Date d1 =  addHelper(d, +15, 2050, 3, 2);
        addHelper(d1, +5, 2050, 3, 7);
    }

    @Test
    public void constructInvalidDateInFebruaryNonLeapYear() {
        assertThrows(DateTimeException.class,
                () -> new Date(2021, 2, 29)
        );
    }

    // use lots of helpers to make actual tests extremely short
    private void addHelper(int y1, int m1, int d1, int add,
                           int y2, int m2, int d2) {
        Date act = new Date(y1, m1, d1);
        act.addDays(add);
        Date exp = new Date(y2, m2, d2);
        assertEquals(exp, act, "after +" + add + " days");
    }

    // use lots of helpers to make actual tests extremely short
    private Date addHelper(Date d, int add,
                           int y2, int m2, int d2) {
        d.addDays(add);
        Date exp = new Date(y2, m2, d2);
        assertEquals(exp, d, "after +" + add + " days");
        return d;
    }


}