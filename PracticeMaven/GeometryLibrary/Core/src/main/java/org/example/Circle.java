package org.example;

public class Circle extends GeometricFigure {

    private int radius;

    public Circle(int radius) throws Exception {
        this.radius = radius;
        if (radius <= 0.0) {
            throw new Exception("Circle doesn't exist");
        }
    }

    public double calculatingTheArea() {
        return radius * radius * Math.PI;
    }

    public double calculatingThePerimeter() {
        return 2 * radius * Math.PI;
    }
}
