package ru.myachin.reusing;

/**
 * 10. Измените {@link ConstructorOrder2 предыдущее упражнение} так, чтобы во всех классах присутствовали лишь
 * конструкторы с аргументами (не поумолчанию).
 */
public class ConstructorOrder3 {

    public static void main(String[] args) {
        new Stemb(Integer.MIN_VALUE);
    }
}

class Component1b {

    Component1b(int i) {
        System.out.println("Constructor Component1b(int i)");
    }
}

class Component2b {

    Component2b(int i) {
        System.out.println("Constructor Component2b(int i)");
    }
}

class Component3b {

    Component3b(int i) {
        System.out.println("Constructor Component3b(int i)");
    }
}

class Rootb {

    Component1b c1 = new Component1b(Integer.MAX_VALUE);
    Component2b c2 = new Component2b(Integer.MAX_VALUE);
    Component3b c3 = new Component3b(Integer.MAX_VALUE);

    Rootb(int i) {
        System.out.println("Constructor Root(int i)");
    }
}

class Stemb extends Rootb {

    Component1b c1 = new Component1b(Integer.MAX_VALUE);
    Component2b c2 = new Component2b(Integer.MAX_VALUE);
    Component3b c3 = new Component3b(Integer.MAX_VALUE);

    Stemb(int i) {
        super(i);
        System.out.println("Constructor Stemb(int i)");
    }
}