package ru.myachin.holding;

import ru.myachin.polymorphism.shape.RandomShapeGenerator;
import ru.myachin.polymorphism.shape.Shape;

/**
 * 31. Измените пример {@link RandomShapeGenerator}, чтобы он реализовал {@link Iterable}. Для этого необходимо
 * добавить конструктор, получающих количество элементов, которые должен создать итератор перед остановкой.
 * Убедитесь в том, что пример работает.
 *
 * @see RandomShapeGenerator
 */
public class IterableRandomShapeGenerator {

    public static void main(String[] args) {
        RandomShapeGenerator gen = new RandomShapeGenerator(10);
        for (Shape shape : gen) {
            shape.draw();
        }
    }
}
