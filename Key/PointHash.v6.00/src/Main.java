import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(4,5);
        Point p2 = new Point(4,5);
        Point p3 = new Point(5,4);

        // When hashCode has NOT been overridden (default) two points with same
        // coordinates (same "state") will have different hashCodes
        System.out.println("p1.hashCode is " + p1.hashCode());
        System.out.println("p2.hashCode is " + p2.hashCode());
        System.out.println("p3.hashCode is " + p3.hashCode());

        System.out.println("\nTest against hashCode contract (p1,p2)");
        testAgainstHashCodeContract(p1, "p1", p2, "p2");
        System.out.println("\nTest against hashCode contract (p1,p3)");
        testAgainstHashCodeContract(p1, "p1", p3, "p3");

        Point p = new Point(4,5);
        Set<Point> set = new HashSet<>();
        set.add(p);

        System.out.println();
        System.out.println("HashSet Tests");
        System.out.println(set.contains(new Point(4,5)));   //true if hashCode is overridden properly; otherwise false
        p.translate(2,2);
        System.out.println(set.contains(new Point(6,7)));   //false - but expecting TRUE - what happened?
    }

    private static void testAgainstHashCodeContract(Object o1, String o1Name, Object o2, String o2Name) {
        if (o1.hashCode() == o1.hashCode()) System.out.println(o1Name + " is self-consistent - GOOD!!");
        else System.out.println(o1Name + " is NOT self-consistent - VIOLATES hashCode contract");
        if (o2.hashCode() == o2.hashCode()) System.out.println(o2Name + " is self-consistent - GOOD!!");
        else System.out.println(o2Name + " is NOT self-consistent - VIOLATES hashCode contract");

        if (o1.equals(o2)) {
            System.out.println(o1Name + " and " + o2Name + " are equal");
            if (o1.hashCode() == o2.hashCode()) {
                System.out.println(o1Name + " and " + o2Name + " have same hashCode - CONSISTENT WITH EQUALITY - GOOD!!");
            }
            else {
                System.out.println(o1Name + " and " + o2Name + " have DIFFERENT hashCodes - NOT consistent with equality - VIOLATES hashCode contract");
            }
        } else {
            System.out.println(o1Name + " and " + o2Name + " are NOT equal");
            if (o1.hashCode() == o2.hashCode()) {
                System.out.println(o1Name + " and " + o2Name + " have same hashCode - POTENTIAL collision - hashCode might need improvement");
            } else {
                System.out.println(o1Name + " and " + o2Name + " have different hashCodes - no potential collision - GOOD!!");
            }
        }
    }
}