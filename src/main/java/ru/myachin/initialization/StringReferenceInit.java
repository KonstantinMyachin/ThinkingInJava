package ru.myachin.initialization;

/**
 * 1. Создайте класс с неинициализированной ссылкой на {@link String}. Покажите, что Java инициализирует ссылку
 * значением <tt>null</tt>.
 */
public class StringReferenceInit {

    String s;

    public static void main(String[] args) {
        StringReferenceInit stringRef = new StringReferenceInit();
        if (stringRef.s == null) {
            System.out.println("Java default initialize object reference as null");
        }
    }
}