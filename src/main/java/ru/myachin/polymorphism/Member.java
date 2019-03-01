package ru.myachin.polymorphism;

public class Member {

    private static int counter = 0;
    private final int id = ++counter;
    private int refCount = 0;

    public Member() {
        System.out.println("Member Constructor");
    }

    public void addReference() {
        refCount++;
    }

    public void dispose() {
        if (--refCount == 0) {
            System.out.println("Disposing Member " + id);
        }
    }
}