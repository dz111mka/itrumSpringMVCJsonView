package org.example;

public class Main {
    public static void main(String[] args) throws Exception {
        GeometricFigure circle = new Circle(4);
        System.out.println(circle.calculatingThePerimeter());
        System.out.println(circle.calculatingTheArea());
    }
}
