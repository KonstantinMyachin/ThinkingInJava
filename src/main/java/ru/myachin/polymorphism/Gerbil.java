package ru.myachin.polymorphism;

public class Gerbil extends Rodent {

    public Gerbil(Member member) {
        super(member);
        System.out.println("Gerbil Constructor");
    }

    @Override
    public void doSomething() {
        System.out.println("Gerbil doSomething()");
    }

    @Override
    public void reproduce() {
        System.out.println("Gerbil reproduce()");
    }
}