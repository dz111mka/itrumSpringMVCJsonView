package org.example;

public class ComparisonFigures {

    public static String compare(GeometricFigure figure1, GeometricFigure figure2) {
        if (figure1.equals(figure2)) {
            return "Фигуры равны";
        } else return  "Фигуры не равны";
    }

}
