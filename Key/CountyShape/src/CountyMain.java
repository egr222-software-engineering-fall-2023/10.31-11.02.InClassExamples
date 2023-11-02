public class CountyMain {
    public static void main(String[] args) {
        County[] counties = {
                new County("Triangle", new Triangle(10, 5)),
                new County("Square", new Square(10)),
                new County("Circle", new Circle(10))
        };

        double totalArea = 0.0;
        for (County county : counties) {
            System.out.println(county.getName() + " (area: " + county.getArea() + " square miles)");
            totalArea += county.getArea();
        }
        System.out.println("Total area: " + totalArea + " square miles");
    }
}