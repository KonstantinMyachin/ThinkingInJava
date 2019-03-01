package ru.myachin.initialization;

/**
 * 9. Подготовьте класс с двумя (перегружеными) конструкторами. Используя ключевое слово <b>this</b>, вызовите второй
 * конструктор из первого.
 */
public class ThisConstructorCall {

    private ThisConstructorCall() {
        this("Hello World!");
        System.out.println("Default Constructot");
    }

    private ThisConstructorCall(String s) {
        System.out.println("Overloaded constructor with argument " + s);
    }

    public static void main(String[] args) {
        new ThisConstructorCall();
    }
}