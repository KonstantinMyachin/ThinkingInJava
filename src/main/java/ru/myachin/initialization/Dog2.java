package ru.myachin.initialization;

/**
 * 6. Измените {@link Dog предыдущее упражнение} так, чтобы два перегруженных метода принимали два аргумента
 * (разных типов) и отличались только порядком их следования в списке аргументов. Проверьте, работает ли это.
 */
public class Dog2 {

    public static void main(String[] args) {
        Dog2 dog = new Dog2();
        dog.bark(1, (short) 1);
        dog.bark((short) 1, 10L);
    }

    void bark(short s, long l) {
        System.out.println("Переход с короткого лая на длинный");
    }

    void bark(long l, short s) {
        System.out.println("Переход с длинного лая на короткий");
    }
}
