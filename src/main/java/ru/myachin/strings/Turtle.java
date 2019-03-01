package ru.myachin.strings;

import java.io.PrintStream;
import java.util.Formatter;

/**
 * 3. Измените пример <tt>Turtle.java</tt> так, чтобы весь выывод направлялся в поток {@link System#err}
 */
public class Turtle {

    private String name;

    private Formatter f;

    public Turtle(String name, Formatter f) {
        this.name = name;
        this.f = f;
    }

    public static void main(String[] args) {
        PrintStream errAlias = System.err;
        Turtle tommy = new Turtle("Tommy", new Formatter(System.err));
        Turtle terry = new Turtle("Terry", new Formatter(errAlias));
        tommy.move(0, 0);
        terry.move(4, 8);
        tommy.move(3, 4);
        terry.move(2, 5);
        tommy.move(3, 3);
        terry.move(3, 3);
    }

    public void move(int x, int y) {
        f.format("%s The Turtle is at (%d, %d)\n", name, x, y);
    }
}