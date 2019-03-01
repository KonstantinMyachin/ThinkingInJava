package ru.myachin.polymorphism;

/**
 * 10. Создайте базовый класс с двумя методами. В первом методе вызовите второй метод. Определите производный класс и
 * переопределите второй метод. Создайте объект производного класса, выполните восходящее преобразование к базовму
 * типу и вызовите первый метод. Объясните результат.
 */
public class BaseClass {

    public static void main(String[] args) {
        BaseClass aClass = new SubClass();
        aClass.doSomething();
    }

    void doSomething() {
        System.out.println("BaseClass doSomething()");
        doSomethingElse();
    }

    void doSomethingElse() {
        System.out.println("BaseClass doSomethingElse()");
    }
}

class SubClass extends BaseClass {

    @Override
    void doSomethingElse() {
        System.out.println("SubClass doSomethingElse()");
    }

}