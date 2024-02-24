package org.example;

public class Triangle extends GeometricFigure {

    private int a;
    private int b;
    private int c;
    private double h;

    public Triangle(int a, int b, int c) throws Exception {
        this.a = a;
        this.b = b;
        this.c = c;
        if (a == 0.0 || b == 0.0 || c == 0.0) {
            throw new Exception("Triangle doesn't exist");
        }
        double p = calculatingThePerimeter() / 2;
        this.h = 2 * Math.sqrt(p * (p - this.a) * (p - this.b) * (p - this.c)) / this.a;
        if (calculatingTheArea() == 0.0) {
            throw new Exception("Triangle doesn't exist");
        }
    }

    public double calculatingTheArea() {
        return h * a / 2 ;
    }

    public double calculatingThePerimeter() {
        return a + b + c;
    }
}
