package ru.myachin.polymorphism.shape;

public class Shapes {

    private static RandomShapeGenerator gen = new RandomShapeGenerator();

    public static void main(String[] args) {
        Shape[] s = new Shape[9];
        for (int i = 0; i < s.length; i++) {
            s[i] = gen.next();
        }

        for (Shape shp : s) {
            shp.draw();
            shp.newMethod();
        }

        Shape shape = new Rectangle();
        shape.draw();
        shape.erase();
    }

    public static RandomShapeGenerator getGen() {
        return gen;
    }
}