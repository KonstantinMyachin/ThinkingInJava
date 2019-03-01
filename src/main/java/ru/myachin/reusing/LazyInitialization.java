package ru.myachin.reusing;

/**
 * 1. Создайте простой класс. Во втором классе определите ссылку на объект первого класса. Используйте отложенную
 * инициализацию для создания экземпляров этого класса.
 */
public class LazyInitialization {

    private Simple simple;

    public static void main(String[] args) {
        new LazyInitialization().doSomething();
    }

    void doSomething() {
        if (simple == null) {
            simple = new Simple();
            System.out.println("Lazy initialization");
        }
    }
}

class Simple {

}
