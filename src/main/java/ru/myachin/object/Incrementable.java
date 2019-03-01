package ru.myachin.object;

/**
 * 7. Превратите фрагменты кода Incrementable в работающую программу.
 */
public class Incrementable {

    public static void main(String[] args) {
        Incrementable sf = new Incrementable();
        sf.increment();
        Incrementable.increment();
        System.out.println(StaticTest.i);
    }

    static void increment() {
        StaticTest.i++;
    }
}