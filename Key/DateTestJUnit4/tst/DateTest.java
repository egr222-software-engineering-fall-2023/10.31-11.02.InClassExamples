import org.junit.Assert;
import org.junit.Test;

import java.time.DateTimeException;

public class DateTest {
    public static final int SIMPLE_TIMEOUT = 1000;
    public static final int COMPLEX_TIMEOUT = 100;

    @Test (timeout = SIMPLE_TIMEOUT)
    public void constructInvalidDateInFebruaryNonLeapYear() {
        try {
            Date act = new Date(2021, 2, 29);
            Assert.fail();
        }
        catch  (DateTimeException e) {
        }
    }

    @Test (timeout = SIMPLE_TIMEOUT)
    public void constructInvalidDateInFebruaryLeapYear() {
        try {
            Date act = new Date(2024, 2, 30);
            Assert.fail();
        }
        catch  (DateTimeException e) {
        }
    }

    @Test (timeout = SIMPLE_TIMEOUT)
    public void constructInvalidDateAtYearBegin() {
        try {
            Date act = new Date(2024, 1, 0);
            Assert.fail();
        }
        catch  (DateTimeException e) {
        }
    }

    @Test (timeout = SIMPLE_TIMEOUT)
    public void constructInvalidDateAtYearEnd() {
        try {
            Date act = new Date(2024, 12, 32);
            Assert.fail();
        }
        catch  (DateTimeException e) {
        }
    }

    @Test (timeout = SIMPLE_TIMEOUT)
    public void addDays_withinSameMonth_1() {
        // Given
        addHelper(2050, 2, 14, 3, 2050, 2, 17);
    }

    @Test (timeout = SIMPLE_TIMEOUT)
    public void addDays_wrapToNextMonthInANonLeapYearMillenium() {
        addHelper(2100, 2, 27, 3, 2100, 3, 2);
    }

    @Test (timeout = SIMPLE_TIMEOUT)
    public void addDays_wrapToNextMonthInANonLeapYearNonMillenium() {
        addHelper(2049, 2, 27, 3, 2049, 3, 2);
    }

    @Test (timeout = SIMPLE_TIMEOUT)
    public void addDays_wrapToNextMonthInALeapYear() {
        addHelper(2052, 2, 27, 3, 2052, 3, 1);
    }

    private void addHelper(int y, int m, int d, int add, int y2, int m2, int d2) {
        Date act = new Date(y, m, d);
        act.addDays(add);
        Date exp = new Date(y2, m2, d2);
        Assert.assertEquals("after " + add + " days", exp, act);
    }

    @Test (timeout = COMPLEX_TIMEOUT)
    public void repeatNextDayOneMillionTimes() {
        // Given
        Date act = new Date();
        for (int i = 1; i < 1000000; i++) {
            act.nextDay();
        }
    }
}