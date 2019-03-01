package ru.myachin.innerclasses;

interface InterfaceWithNestedClass {

    String getMessage();

    class Nested {
        static void staticMethod(InterfaceWithNestedClass i) {
            System.out.println(i.getMessage());
        }
    }
}

/**
 * 21. Создайте интерфейс с вложенным классом, содержащим статический метод, который вызывает методы вашего интерфейса
 * и выводит результаты. Реализуйте интерфейс и передайте экземпляр своей реализации методу.
 */
public class NestedInsideInterface2 {

    public static void main(String[] args) {
        InterfaceWithNestedClassImpl interfaceWithNestedClass = new InterfaceWithNestedClassImpl();
        InterfaceWithNestedClass.Nested.staticMethod(interfaceWithNestedClass);
    }
}

class InterfaceWithNestedClassImpl implements InterfaceWithNestedClass {

    @Override
    public String getMessage() {
        return "Awesome!!!";
    }
}