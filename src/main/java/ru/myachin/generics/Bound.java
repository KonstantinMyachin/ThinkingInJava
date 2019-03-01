package ru.myachin.generics;

/**
 * 20. Создайте интерфейс с двумя методами и класс, который реализует этот интерфейс и добавляет еще один метод.
 * В другом классе создайте обобщенный метод с аргументом-типом, ограниченным по интерфейсу; покажите, что методы
 * интерфейса могут вызываться в этом обобщенном методе. В {@link #main(String[])} передайте экземпляр реализующего
 * класса обобщенному методу.
 */
public class Bound {

    public static void main(String[] args) {
        foo(new TheImplementation());
    }

    private static <T extends TheInterface> void foo(T generic) {
        generic.doSomething();
        generic.doSomethingElse();
    }

}
interface TheInterface {

    void doSomething();

    void doSomethingElse();
}

class TheImplementation implements TheInterface {

    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void doSomethingElse() {
        System.out.println("doSomethingElse");
    }

    public void anotherMethod() {
        System.out.println("anotherMethod");
    }
}
