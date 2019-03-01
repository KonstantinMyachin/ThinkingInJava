package ru.myachin.polymorphism;

public class Bicycle extends Cycle {

    @Override
    public int wheels() {
        return 2;
    }

    public void balance() {
        System.out.println("Bicycle balance()");
    }
}