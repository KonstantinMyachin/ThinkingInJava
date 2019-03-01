package ru.myachin.polymorphism;

import ru.myachin.interfaces.FastFood;

/**
 * 11. Включите класс <b>Pickle</b> в программу <b>Sandwich.java</b>.
 *
 * @see FastFood
 * @see PortableLunch
 */
public class Sandwich extends PortableLunch implements FastFood {

    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Lettuce l = new Lettuce();
    private Pickle p = new Pickle();

    public Sandwich() {
        System.out.println("Sandwich()");
    }

    public static void main(String[] args) {
        Sandwich sandwich = new Sandwich();
        sandwich.buy();
        sandwich.eat();
    }

    @Override
    public void eat() {
        System.out.println("Sandwich was eaten");
    }

    @Override
    public void buy() {
        System.out.println("Sandwich was bought");
    }
}

class Meal {

    Meal() {
        System.out.println("Meal()");
    }
}

class Bread {

    Bread() {
        System.out.println("Bread()");
    }
}

class Cheese {

    Cheese() {
        System.out.println("Cheese()");
    }
}

class Lettuce {

    Lettuce() {
        System.out.println("Lettuce()");
    }
}

class Lunch extends Meal {

    Lunch() {
        System.out.println("Lunch()");
    }
}

class PortableLunch extends Lunch {

    PortableLunch() {
        System.out.println("PortableLunch()");
    }
}

class Pickle {

    Pickle() {
        System.out.println("Pickle");
    }
}