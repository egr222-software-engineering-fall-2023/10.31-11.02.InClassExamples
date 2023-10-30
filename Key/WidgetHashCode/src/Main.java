import java.util.*;

// Class demonstrating problem when equals is overridden but hashCode is not overridden
public class Main {
    public static void main(String[] args) {
        Set<Widget> set1 = new HashSet<Widget>();

        Widget w1 = new Widget("Coca Cola");
        Widget w2 = new Widget("Coca Cola");

        // equals has been overridden in Widget class
        set1.add(w1);  // adds w1 to the set
        set1.add(w2);  // should replace w1 in the set, but instead w2 is added as a second element

        System.out.println("w1.equals(w2): " + w1.equals(w2)); // TRUE:  objects ARE equal
        System.out.println("w1.hashCode(): " + w1.hashCode()); // memory location
        System.out.println("w2.hashCode(): " + w2.hashCode()); // memory location
        System.out.println(set1.size()); // 2 - BUT should be 1 - why?
        // Since w1 and w2 have different hashCodes they were seen as UNEQUAL objects
    }
}