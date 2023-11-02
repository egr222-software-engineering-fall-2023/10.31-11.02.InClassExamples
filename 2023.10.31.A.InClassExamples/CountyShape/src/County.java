public class County {
    private String name;
    private Square square;
    private Triangle triangle;
    private Circle circle;

    public County(String name, Triangle triangle) {
        this.name = name;
        this.triangle = triangle;
    }

    public County(String name, Square square) {
        this.name = name;
        this.square = square;
    }

    public County(String name, Circle circle) {
        this.name = name;
        this.circle = circle;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        if (triangle != null)
            return triangle.getArea();
        else if (square != null)
            return square.getArea();
        else if (circle != null)
            return circle.getArea();
        else
            return 0.0;
    }
}