package ru.myachin.initialization;

/**
 * 3. Создайте класс с конструктором по умолчанию (без параметров), который выводит на экран сообщение. Создайте
 * объект этого класса.
 */
public class DefaultConstructor {

    public DefaultConstructor() {
        System.out.println("It'a a default constructor");
    }

    public static void main(String[] args) {
        new DefaultConstructor();
    }
}
