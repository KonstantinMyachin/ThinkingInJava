package ru.myachin.innerclasses;

/**
 * 18. Создайте класс, содержащий вложенный класс. Создайте в методе <b>main()</b> экземпляр вложенного класса.
 */
public class NestedClass {

    public static void main(String[] args) {
        new Nested();
    }

    static class Nested {
        public Nested() {
            System.out.println("Nested class constructor");
        }
    }
}