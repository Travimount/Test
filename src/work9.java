import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

class Triangle implements Comparable<Triangle> {
    private int id;
    private double a, b, c;

    public Triangle(int id, double a, double b, double c) {
        this.id = id;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getArea() {
        double s = getPerimeter() / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public double getPerimeter() {
        return a + b + c;
    }

    public boolean isRightTriangle() {
        double[] sides = {a, b, c};
        Arrays.sort(sides);
        return Math.abs(sides[2] * sides[2] - (sides[0] * sides[0] + sides[1] * sides[1])) < 0.000001;
    }

    @Override
    public String toString() {
        return "Triangle ID: " + id + " - Perimeter: " + getPerimeter() + " - Area: " + getArea() + " - isRightTriangle: " + isRightTriangle();
    }

    @Override
    public int compareTo(Triangle o) {
        int comparePerimeter = Double.compare(this.getPerimeter(), o.getPerimeter());
        if (comparePerimeter != 0) return comparePerimeter;

        int compareArea = Double.compare(this.getArea(), o.getArea());
        if (compareArea != 0) return compareArea;

        return Integer.compare(this.id, o.id);
    }
}

public class work9{
    public static void main(String[] args) {
        List<Triangle> triangles = new ArrayList<>();
        triangles.add(new Triangle(1, 5.1, 8.2, 5.5));
        triangles.add(new Triangle(2, 8.5, 14, 17));
        triangles.add(new Triangle(3, 3, 4, 5));
        triangles.add(new Triangle(4, 12.5, 23, 30));
        triangles.add(new Triangle(5, 10.5, 25, 30));
        triangles.add(new Triangle(6, 5.1, 8.2, 5.5));

        Collections.sort(triangles);

        for (Triangle triangle : triangles) {
            System.out.println(triangle);
        }
    }
}