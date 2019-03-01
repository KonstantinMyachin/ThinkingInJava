package ru.myachin.typeinfo;

import ru.myachin.polymorphism.shape.Circle;
import ru.myachin.polymorphism.shape.Shape;

/**
 * 3. Создайте класс <tt>Rhomboid</tt> в иерархии {@link ru.myachin.polymorphism.shape.Shapes}. Создайте объект
 * класса <tt>Rhomboid</tt>, выполните восходящее преобразование его в {@link Shape}, а затем снова верните его
 * к классу {@link Rhomboid} нисходящим преобразованием. Попробуйте выполнить нисходящее преобразование к
 * {@link ru.myachin.polymorphism.shape.Circle} и объясните, что при этом происходит
 * <p>
 * 4. Измените предыдущий пример, чтобы перед нисходящим преобразованием в нем использовался оператор
 * <tt>instanceof</tt> для проверки типа.
 */
public class Rhomboid extends Shape {

    public static void main(String[] args) {
        Shape shape = new Rhomboid();
        Rhomboid rhomboid = (Rhomboid) shape;
        if (shape instanceof Circle) {
            Circle circle = ((Circle) shape); //Runtime Exception without instnaceof check: ClassCastException
        }
    }

    @Override
    public String toString() {
        return highLighted ? "Rhomboid is highLighted" : "Rhomboid isn't highLighted";
    }
}