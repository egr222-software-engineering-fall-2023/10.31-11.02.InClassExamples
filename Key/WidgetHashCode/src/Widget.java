public class Widget {
    String name;

    public Widget(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {                       // Good implementation
        if (o != null && getClass() == o.getClass()) {      // Checks for NULL and then uses getClass() to compare TYPE
            Widget other = (Widget) o;
            return name.equals(other.name);
        } else {
            return false;
        }
    }

//    @Override
//    public int hashCode() {
//        return name.hashCode();
//    }
}