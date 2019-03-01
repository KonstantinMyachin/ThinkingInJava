package ru.myachin.innerclasses;

/**
 * 15. Создайте класс, не содержащий конструктор по умолчанию (конструктор без аргументов). При этом класс должен
 * содержать конструктор, получающий аргументы. Создайте второй класс с методом, который возвращает ссылку на объект
 * первого класса. Возвращаемый объект должен создаваться посредством анонимного внутреннего класса, производного от
 * первого.
 */
public class AnonymousInstance {

    public static void main(String[] args) {
        new Second().getAnonymous();
    }
}

class WithOutDefaultConstructor {

    public WithOutDefaultConstructor(int i) {
        System.out.println("Constructor argument = " + i);
    }
}

class Second {

    WithOutDefaultConstructor getAnonymous() {
        return new WithOutDefaultConstructor(5);
    }
}