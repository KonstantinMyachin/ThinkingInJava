package ru.myachin.typeinfo;

/**
 * 10. Напишите программу, которая определяет, является ли массив <tt>char</tt> примитивным типом или "настоящим"
 * объектом.
 */
public class PrimitiveOrObjectChecker {

    public static void main(String[] args) {
        System.out.println(isPrimitive(new char[2].getClass()));
    }

    public static boolean isPrimitive(final Class aClass) {
        return aClass.isPrimitive();
    }
}