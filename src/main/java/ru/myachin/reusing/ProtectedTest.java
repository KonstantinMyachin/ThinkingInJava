package ru.myachin.reusing;

import ru.myachin.reusing.protect.Protected;

/**
 * @see Protected
 */
public class ProtectedTest {

    public static void main(String[] args) {
        new Derived().doSomething();
//        new Protected().protectedMethod(); Can't access from another package
    }
}

class Derived extends Protected {

    void doSomething() {
        protectedMethod();
    }
}