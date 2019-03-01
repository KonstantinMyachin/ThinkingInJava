package ru.myachin.typeinfo.pack;

public class SomePackClass {

    private void privateMethod() {
        System.out.println("privateMethod");
    }

    void packagePrivateMethod() {
        System.out.println("packagePrivateMethod");
    }

    protected void protectedMethod() {
        System.out.println("protectedMethod");
    }

    public void publicMethod() {
        System.out.println("publicMethod");
    }
}
