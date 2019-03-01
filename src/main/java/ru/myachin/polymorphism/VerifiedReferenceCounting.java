package ru.myachin.polymorphism;

/**
 * 14. Включите метод {@link #finalize()} в <b>ReferenceCounting.java</b>, чтобы проверить условие завершения
 * (см. главу 5)
 */
public class VerifiedReferenceCounting {

    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] composings = {
                new Composing(shared), new Composing(shared), new Composing(shared),
                new Composing(shared), new Composing(shared), new Composing(shared),
                new Composing(shared), new Composing(shared), new Composing(shared)
        };

        for (Composing composing : composings) {
            composing.dispose();
        }

        System.gc();
        System.runFinalization();

        new Composing(new Shared());
        System.gc();
        System.runFinalization();
    }
}

class Shared {

    private static int counter = 0;
    private final int id = ++counter;
    private int refCount = 0;

    public Shared() {
        System.out.println("Creating " + this);
    }

    public void addReference() {
        refCount++;
    }

    public void dispose() {
        if (--refCount == 0) {
            System.out.println("Disposing " + this);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        if (refCount != 0) {
            System.out.println("Error: Object is not properly cleaned up");
        }
    }

    @Override
    public String toString() {
        return "Shared " + id;
    }
}

class Composing {

    private static int counter = 0;
    private final int id = ++counter;
    private Shared shared;

    public Composing(Shared shared) {
        System.out.println("Creating " + this);
        this.shared = shared;
        this.shared.addReference();
    }

    public void dispose() {
        System.out.println("Disposing " + this);
        shared.dispose();
    }

    @Override
    public String toString() {
        return "Composing " + id;
    }
}