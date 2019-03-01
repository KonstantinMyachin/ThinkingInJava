package ru.myachin.polymorphism.shape;

/**
 * @see Shape
 */
public class Triangle extends Shape {

    @Override
    public void draw() {
        System.out.println("Triangle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Triangle.erase()");
    }

    @Override
    public void newMethod() {
        System.out.println("Triangle.newMethod()");
    }

    @Override
    public String toString() {
        return highLighted ? "Triangle is highLighted" : "Triangle isn't highLighted";
    }
}