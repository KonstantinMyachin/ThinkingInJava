package ru.myachin.polymorphism;

public class Hamster extends Rodent {

    public Hamster(Member member) {
        super(member);
        System.out.println("Hamster Constructor");
    }

    @Override
    public void doSomething() {
        System.out.println("Hamster doSomething()");
    }

    @Override
    public void reproduce() {
        System.out.println("Hamster reproduce()");
    }
}