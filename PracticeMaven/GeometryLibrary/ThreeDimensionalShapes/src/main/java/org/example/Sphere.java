package org.example;

public class Sphere extends GeometricFigure3D {

    private int radius;

    public Sphere(int radius) throws Exception {
        this.radius = radius;
        if (radius <= 0.0) {
            throw new Exception("Sphere doesn't exist");
        }
    }


    @Override
    public double calculatingTheArea() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double calculatingTheVolume() {
        return 4 * Math.PI * radius * radius * radius / 3;
    }
}
