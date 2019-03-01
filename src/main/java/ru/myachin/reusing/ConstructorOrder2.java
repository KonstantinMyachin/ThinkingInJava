package ru.myachin.reusing;

/**
 * 9. Создайте класс <b>Root</b>, содержащий экземпляры каждого из классов (также созданных вами)
 * <b>Component1, Component2, Component3</b>. Объявите класс <b>Stem</b> производный от класса <b>Root</b>, так чтобы в
 * нем также содержались экземпляры каждого из упомянутых классов <b>Component</b>. Каждый класс должен содержать
 * кнструктор по умолчанию, который выводит сообщение о своем вызове.
 * <p>
 * 12. Включите иерархию методов <b>dispose()</b> во все классы из {@link ConstructorOrder2 упражнения 9}.
 */
public class ConstructorOrder2 {

    public static void main(String[] args) {
        Stem stem = new Stem();
        stem.dispose();
    }
}

class Component1 {

    Component1() {
        System.out.println("Constructor Component1()");
    }

    void dispose() {
        System.out.println("Component1.dispose()");
    }
}

class Component2 {

    Component2() {
        System.out.println("Constructor Component2()");
    }

    void dispose() {
        System.out.println("Component2.dispose()");
    }
}

class Component3 {

    Component3() {
        System.out.println("Constructor Component3()");
    }

    void dispose() {
        System.out.println("Component3.dispose()");
    }
}

class Root {

    Component1 c1 = new Component1();
    Component2 c2 = new Component2();
    Component3 c3 = new Component3();

    Root() {
        System.out.println("Constructor Root()");
    }

    void dispose() {
        System.out.println("Root.dispose()");
        c1.dispose();
        c2.dispose();
        c3.dispose();
    }
}

class Stem extends Root {

    Component1 c1 = new Component1();
    Component2 c2 = new Component2();
    Component3 c3 = new Component3();

    Stem() {
        System.out.println("Constructor Stem()");
    }

    void dispose() {
        System.out.println("Stem.dispose()");
        c1.dispose();
        c2.dispose();
        c3.dispose();
        super.dispose();
    }
}