import java.time.LocalDate;

public class Date {
    private int y;
    private int m;
    private int d;
    private LocalDate ld;

    public Date() {
        ld = LocalDate.now();
        this.y = ld.getYear();
        this.m = ld.getMonthValue();
        this.d = ld.getDayOfMonth();
    }

    public Date(int y, int m, int d) {
        this.ld = LocalDate.of(y, m, d);
        this.y = y;
        this.m = m;
        this.d = d;
    }

    public int getYear() {
        return y;
    }

    public int getMonth() {
        return m;
    }

    public int getDay() {
        return d;
    }

    public void addDays(int daysToAdd) {
        ld = ld.plusDays(daysToAdd);
        y = ld.getYear();
        m = ld.getMonthValue();
        d = ld.getDayOfMonth();
    }

    public int daysInMonth() {
        return ld.getMonth().length(isLeapYear());
    }

    public String dayOfWeek() {
        return ld.getDayOfWeek().toString();
    }

    public boolean isLeapYear() {
        return ld.isLeapYear();
    }

    public void nextDay() {  // advanced by 1 day
        addDays(1);
    }

    @Override
    public String toString() {
        return LocalDate.of(y, m, d).toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            Date other = (Date) obj;
            return y == other.getYear() && m == other.getMonth() && d == other.getDay();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return LocalDate.of(y, m, d).hashCode();
    }
}