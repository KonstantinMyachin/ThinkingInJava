package ru.myachin.typeinfo;

import ru.myachin.polymorphism.shape.Circle;
import ru.myachin.polymorphism.shape.RandomShapeGenerator;
import ru.myachin.polymorphism.shape.Shape;

/**
 * 5. Реализуйте в <tt>Shapes.java</tt> метод <b>rotate(Shape)</b>, который проверяет, не относится ли фигура к классу
 * {@link Circle} (и если относится - не выполняет ли операцию).
 * <p>
 * 6. Измените пример <tt>Shapes.java</tt> так, чтобы он мог "выделять" (установкой внутреннеого флага) все фигуры
 * некоторого типа. Метод {@link Object#toString()} каждого класса, производного от {@link Shape}, должен указывать
 * находится ли данная фигура в "выделенном" состоянии.
 */
public class Shapes {

    public static void main(String[] args) {
        final RandomShapeGenerator shapeGenerator = ru.myachin.polymorphism.shape.Shapes.getGen();
        Shape[] s = new Shape[9];
        for (int i = 0; i < s.length; i++) {
            s[i] = shapeGenerator.next();
        }

        for (Shape shape : s) {
            try {
                rotate(shape);
            } catch (UnsupportedOperationException e) {
                System.out.println(shape.getClass().getSimpleName() + " can't be rotated!");
                shape.highLight();
            }

            shape.draw();
        }
    }

    static void rotate(Shape shape) {
        if (shape instanceof Circle)
            System.out.println(shape + " was rotated!");
        else
            throw new UnsupportedOperationException();
    }
}