package ru.myachin.polymorphism;

/**
 * 16. Включите класс <b>RectangularGlyph</b> в <b>PolyConstructors.java</b>. Продемонстрируйте проблему описанную в
 * этом разделе: из конструктора базового класса может быть вызван метод производного класса.
 */
public class PolyConstructors {

    public static void main(String[] args) {
        new RoundGlyph(5);
        new RectangularGlyph(5, 5);
    }
}

class Glyph {

    Glyph() {
        System.out.println("Glyph() перед вызовом draw()");
        draw();
        System.out.println("Glyph() после вызова draw()");
    }

    void draw() {
        System.out.println("Glyph.draw()");
    }
}

class RoundGlyph extends Glyph {

    private int radius = 1;

    public RoundGlyph(int radius) {
        this.radius = radius;
    }

    @Override
    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }
}

class RectangularGlyph extends Glyph {

    private int width;
    private int height;

    public RectangularGlyph(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    void draw() {
        System.out.println("RectangularGlyph.draw(), width = " + width + ", height = " + height);
    }
}