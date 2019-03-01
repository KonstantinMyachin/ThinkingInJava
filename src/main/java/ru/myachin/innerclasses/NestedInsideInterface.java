package ru.myachin.innerclasses;

interface InsideInterface {

    void doSomething();

    class Nested implements InsideInterface {
        public Nested() {
            System.out.println("Nested class inside interface");
        }

        @Override
        public void doSomething() {
            System.out.println("Nested.doSomething()");
        }
    }
}

/**
 * 20. Создайте интерфейс, содержащий вложенный класс. Реализуйте интерфейс и создайте экземпляр вложенного класса.
 */
public class NestedInsideInterface {

    public static void main(String[] args) {
        new InsideInterface.Nested().doSomething();
    }
}