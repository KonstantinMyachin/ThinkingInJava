package ru.myachin.typeinfo;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * 8. Напишите метод, который получает побъект и рекурсивно выводит все классы в иерархии этого объекта.
 * <p>
 * 9. Измените предыдущее упражнение так, чтобы в нем использовался метод {@link Class#getDeclaredFields()} для вывода
 * информации о полях класса.
 */
public class RecursiveClassPrint {

    public static void main(String[] args) {
        printHierarchy(ArrayList.class);
    }

    static void printHierarchy(Class c) {
        if (c == null)
            return;

        System.out.println(c.getName());
        for (Field field : c.getDeclaredFields()) {
            System.out.println(String.format(" ----- has field: %s", field.getName()));
        }

        for (Class aClass : c.getInterfaces()) {
            System.out.println(String.format(" --- implements interface: %s", aClass.getName()));
            printHierarchy(aClass.getSuperclass());
        }

        printHierarchy(c.getSuperclass());
    }
}