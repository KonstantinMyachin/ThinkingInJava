package ru.myachin.polymorphism.shape;

/**
 * 4. Добавьте новый подтип {@link Shape} к прокрамме {@link Shapes} и проверьте на методе {@link Shapes#main(String[])},
 * что полиморфизм работает правильно для вашего нового типа, так же как и для старых типов.
 */
public class Rectangle extends Shape {

    @Override
    public void draw() {
        System.out.println("Rectangle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Rectangle.erase()");
    }

    @Override
    public void newMethod() {
        System.out.println("Rectangle.newMethod()");
    }

    @Override
    public String toString() {
        return highLighted ? "Rectangle is highLighted" : "Rectangle isn't highLighted";
    }
}