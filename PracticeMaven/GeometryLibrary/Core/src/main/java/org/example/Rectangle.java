package org.example;

public class Rectangle extends GeometricFigure {

    private final int a;
    private final int b;

    public Rectangle(int a, int b) throws Exception {
        this.a = a;
        this.b = b;

        if (a == 0.0 || b == 0.0) {
            throw new Exception("Rectangle doesn't exist");
        }
    }

    public double calculatingTheArea() {
        return a * b;
    }

    public double calculatingThePerimeter() {
        return 2 * (a + b);
    }
}
