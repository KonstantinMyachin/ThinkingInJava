package ru.myachin.polymorphism;

public class Rodent {

    Member member;

    Rodent(Member member) {
        System.out.println("Rodent Constructor");
        this.member = member;
        this.member.addReference();
    }

    public void doSomething() {
        System.out.println("Rodent doSomething()");
    }

    public void reproduce() {
        System.out.println("Rodent reproduce()");
    }

    void dispose() {
        System.out.println("Disposing " + this);
        member.dispose();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
