public class Circle {
    private double radius;

    private static final double PI = 3.141592653589793238462643383279502884197169399375105820974944592307816406286;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return PI * radius * radius;
    }
}