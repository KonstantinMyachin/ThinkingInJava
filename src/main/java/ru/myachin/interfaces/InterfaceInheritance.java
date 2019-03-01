package ru.myachin.interfaces;

interface FirstInterface {

    void doSomething();

    void doSomethingElse();
}

interface SecondInterface {

    void doSomething2();

    void doSomethingElse2();
}

interface OneMoreInterface {

    void doSomething3();

    void doSomethingElse3();
}

interface MultipleInterface extends FirstInterface, SecondInterface, OneMoreInterface {

    void oneMoreMethod();
}

/**
 * 14. Создайте три интерфейса, каждый из которых содержит два метода. Объявите новый интерфейс, производный от первых
 * трех, включите в него новый метод. Создайте класс, который реализует интерфейс, а также является производным от
 * конкретного класса. Напишите четыре метода, каждый из которых получает один из четырех интерфейсов в аргументе.
 * Создайте в <b>main()</b> объект этого класса и передайте его каждому из методов.
 * <p>
 * 15. Измените предыдущее упражнение - создайте абстрактный класс и унаследуйте производный класс от него.
 */
public class InterfaceInheritance {

    public static void a(FirstInterface i) {
        i.doSomething();
        i.doSomethingElse();
    }

    public static void b(SecondInterface i) {
        i.doSomething2();
        i.doSomethingElse2();
    }

    public static void c(OneMoreInterface i) {
        i.doSomething3();
        i.doSomethingElse3();
    }

    public static void d(MultipleInterface i) {
        i.oneMoreMethod();
    }

    public static void main(String[] args) {
        Implementation implementation = new Implementation();
        a(implementation);
        b(implementation);
        c(implementation);
        d(implementation);
    }
}

abstract class Parent implements MultipleInterface {

    public Parent() {
        System.out.println("Parent constructor");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

class Implementation extends Parent {

    @Override
    public void doSomething() {
        System.out.println(this + " doSomething()");
    }

    @Override
    public void doSomethingElse() {
        System.out.println(this + " doSomethingElse()");
    }

    @Override
    public void doSomething2() {
        System.out.println(this + " doSomething2()");
    }

    @Override
    public void doSomethingElse2() {
        System.out.println(this + " doSomethingElse2()");
    }

    @Override
    public void doSomething3() {
        System.out.println(this + " doSomething3()");
    }

    @Override
    public void doSomethingElse3() {
        System.out.println(this + " doSomethingElse3()");
    }

    @Override
    public void oneMoreMethod() {
        System.out.println(this + " oneMoreMethod()");
    }
}