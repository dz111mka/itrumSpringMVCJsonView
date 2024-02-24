package org.example;

public class Cube extends GeometricFigure3D {
    private final int a;

    public Cube(int a) throws Exception {
        this.a = a;

        if (a == 0.0) {
            throw new Exception("Cube doesn't exist");
        }
    }

    @Override
    public double calculatingTheArea() {
        return 6 * a * a;
    }

    @Override
    public double calculatingTheVolume() {
        return a * a * a;
    }
}
