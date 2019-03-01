package ru.myachin.exceptions;

/**
 * 16. Измените пример <b>reusing/CADSystem.java</b> и покажите, что при возврате управления из серидины
 * <tt>try-finally</tt> все равно выполняются необходимые завершаюзие действия
 *
 * @see Shape
 */
public class CADSystem extends Shape {

    private Circle c;
    private Triangle t;
    private Line[] lines = new Line[3];

    CADSystem(int i) {
        super(i + 1);
        for (int j = 0; j < lines.length; j++) {
            lines[j] = new Line(i, j * j);
        }

        c = new Circle(i);
        t = new Triangle(i);
        System.out.println("Комбинированный конструктор");
    }

    public static void main(String[] args) {
        CADSystem x = new CADSystem(47);
        try {
            return;
        } finally {
            x.dispose();
        }
    }

    @Override
    void dispose() {
        System.out.println("CADSystem.dispose()");
        t.dispose();
        c.dispose();
        for (int i = 0; i < lines.length; i++) {
            lines[i].dispose();
        }
        super.dispose();
    }
}

class Shape {
    Shape(int i) {
        System.out.println("Конструктор Shape");
    }

    void dispose() {
        System.out.println("Завершение Shape");
    }
}

class Circle extends Shape {

    Circle(int i) {
        super(i);
        System.out.println("Рисуем окружность Circle");
    }

    @Override
    void dispose() {
        System.out.println("Стираем окружность Circle");
        super.dispose();
    }
}

class Triangle extends Shape {

    Triangle(int i) {
        super(i);
        System.out.println("Рисуем Triangle");
    }

    @Override
    void dispose() {
        System.out.println("Стираем Triangle");
        super.dispose();
    }
}

class Line extends Shape {

    private int start, end;

    Line(int start, int end) {
        super(start);
        this.start = start;
        this.end = end;
        System.out.println("Рисуем линию Line: " + start + ", " + end);
    }

    @Override
    void dispose() {
        System.out.println("Стираем окружность Line: " + start + ", " + end);
        super.dispose();
    }
}