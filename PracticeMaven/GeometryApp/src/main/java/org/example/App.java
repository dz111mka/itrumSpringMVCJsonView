package org.example;

import java.util.ArrayList;
import java.util.List;
/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {

        List<GeometricFigure> list = new ArrayList<>();
        list.add(new Rectangle(1, 2));
        list.add(new Circle(4));
        list.add(new Triangle(2, 2, 3));

        for (GeometricFigure figures : list) {
            System.out.println("Фигура " + figures.getClass().getName() + " имеет Периметр равный " + figures.calculatingThePerimeter() + " и Площадь равную " + figures.calculatingTheArea());
        }

        System.out.println(ComparisonFigures.compare(list.get(0), list.get(0)));




    }
}
