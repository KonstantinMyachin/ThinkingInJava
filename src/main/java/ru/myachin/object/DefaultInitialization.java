package ru.myachin.object;

/**
 * 1. Создайте класс с полями int и char, которые не инициализируются в программе. Выведите их значения, чтобы
 * убедиться в том, что Java выполняеDт инициализацию по умолчанию.
 */
public class DefaultInitialization {

    int i;
    char c;

    public static void main(String[] args) {
        DefaultInitialization di = new DefaultInitialization();
        System.out.println(di.i);
        System.out.println(di.c);
    }
}