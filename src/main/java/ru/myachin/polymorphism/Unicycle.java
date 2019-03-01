package ru.myachin.polymorphism;

public class Unicycle extends Cycle {

    @Override
    public int wheels() {
        return 1;
    }

    public void balance() {
        System.out.println("Unicycle balance()");
    }
}