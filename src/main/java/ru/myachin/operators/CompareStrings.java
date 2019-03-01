package ru.myachin.operators;

/**
 * 14. Напишите метод, который получает два аргумента {@link String}, выполняет с ними все операции логических сравнений
 * и выводит результаты. Для операций <b>==</b> и <b>!=</b> так же выполните проверку {@link #equals(Object)}. Вызовите
 * свой метод из {@link #main(String[])} для нескольких разных объектов {@link String}.
 */
public class CompareStrings {

    public static void main(String[] args) {
        compare("Hello", "World");
        compare("Jone", "Java");
    }

    static void compare(String s1, String s2) {
        System.out.println(String.format("%s == %s :%b", s1, s2, s1 == s2));
        System.out.println(String.format("%s != %s :%b", s1, s2, s1 != s2));
        System.out.println(String.format("%s equals %s :%b", s1, s2, s1.equals(s2)));
    }
}