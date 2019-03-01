package ru.myachin.polymorphism.shape;

import java.util.Iterator;
import java.util.Random;

public class RandomShapeGenerator implements Iterable<Shape> {

    private Random rand = new Random(47);

    private Shape[] shapes;

    public RandomShapeGenerator() {
    }

    public RandomShapeGenerator(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("Количество сгенерированных объектов должно быть положительным числом");
        }

        shapes = new Shape[count];
        for (int i = 0; i < count; i++) {
            shapes[i] = next();
        }
    }

    public Shape next() {
        switch (rand.nextInt(3)) {
            default:
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
        }
    }

    @Override
    public Iterator<Shape> iterator() {
        return new Iterator<Shape>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < shapes.length;
            }

            @Override
            public Shape next() {
                return shapes[index++];
            }
        };
    }
}