package ru.myachin.initialization;

/**
 * 5. Создайте класс <b>Dog</b> с перегруженным методом <b>bark() (лай)</b>. Метод должен быть перегурежн для разных
 * примитивных типов данных с целью вывода сообщения о лае, завывании, поскуливании и т. п. в зависимости от версии
 * перегруженного метода. Напишите метод <b>main()</b>, вызывающий все версии.
 */
public class Dog {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.bark();
        dog.bark((byte) 1);
        dog.bark('a');
        dog.bark((short) 1);
        dog.bark(1);
        dog.bark(1L);
        dog.bark(1.1f);
        dog.bark(1.1);
    }

    void bark() {
        System.out.println("Лай по умолчанию");
    }

    void bark(byte b) {
        System.out.println("Лай размером в байт " + b);
    }

    void bark(char c) {
        System.out.println("Лай размером с буквы " + c);
    }

    void bark(short s) {
        System.out.println("Короткий лай " + s);
    }

    void bark(int i) {
        System.out.println("Самый распространенный лай " + i);
    }

    void bark(long l) {
        System.out.println("Длинный лай " + l);
    }

    void bark(float f) {
        System.out.println("Плавающий лай " + f);
    }

    void bark(double d) {
        System.out.println("Более точный плавающий лай " + d);
    }
}
