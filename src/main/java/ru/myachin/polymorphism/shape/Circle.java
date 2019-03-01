package ru.myachin.polymorphism.shape;

/**
 * @see Shape
 */
public class Circle extends Shape {

    @Override
    public void draw() {
        System.out.println("Circle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Circle.erase");
    }

    @Override
    public void newMethod() {
        System.out.println("Circle.newMethod()");
    }

    @Override
    public String toString() {
        return highLighted ? "Circle is highLighted" : "Circle isn't highLighted";
    }
}