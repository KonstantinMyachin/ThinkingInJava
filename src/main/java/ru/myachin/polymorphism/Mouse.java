package ru.myachin.polymorphism;

public class Mouse extends Rodent {

    public Mouse(Member member) {
        super(member);
        System.out.println("Mouse Constructor");
    }

    @Override
    public void doSomething() {
        System.out.println("Mouse doSomething()");
    }

    @Override
    public void reproduce() {
        System.out.println("Mouse reproduce()");
    }
}