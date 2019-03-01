package ru.myachin.typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 20. Найдите описание класса {@link Class} в документации <a href="http://java.sun.com">JDK</a>. Напишите программу,
 * которая получает имя класса в параметре командной строки, а затем использует методы класса {@link Class} для вывода
 * всей доступной информации о классе. Протестируйте программу на одном из классов стандартной библиотеки <tt>Java</tt>
 * и на своем собственном классе.
 */
public class ShowClassInfo {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: ShowClassInfo qualified.class.name");
            System.exit(-1);
        }

        try {
            final Class<?> aClass = Class.forName(args[0]);
            System.out.println(String.format("Extends %s", aClass.getSuperclass()));
            System.out.println("\nImplements:");
            for (Class<?> anInterface : aClass.getInterfaces()) {
                System.out.println(anInterface.toString());
            }
            System.out.println("\nFields:");
            for (Field declaredField : aClass.getDeclaredFields()) {
                System.out.println(declaredField.toString());
            }

            System.out.println("\nConstructors:");
            for (Constructor<?> declaredConstructor : aClass.getDeclaredConstructors()) {
                System.out.println(declaredConstructor.toString());
            }

            System.out.println("\nMethods:");
            for (Method declaredMethod : aClass.getDeclaredMethods()) {
                System.out.println(declaredMethod.toString());
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
