package ru.myachin.initialization;

/**
 * 4. Добавьте к {@link DefaultConstructor классу из упражнения 3} перегруженный конструктор, принимающий в качестве
 * параметра строку {@link String} и распечатывающий ее вместе с сообщением.
 */
public class OverloadedConstructor {

    private OverloadedConstructor() {
        System.out.println("It's a default constructor");
    }

    private OverloadedConstructor(String s) {
        System.out.println("It's a overloaded constructor " + s);
    }

    public static void main(String[] args) {
        new OverloadedConstructor();
        new OverloadedConstructor("ok");
    }
}