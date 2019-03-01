package ru.myachin.initialization;

/**
 * 14. Создайте класс с полем <b>static {@link String}</b>, инициализированными в точке определения, и в другим полем,
 * инициализированным в блоке <b>static</b>. Добавьте статический метод, который выводи значения полей и демонстрирует,
 * что оба поля инициализируются перед использованием.
 */
public class StaticStringInitialization {

    private static String s1 = "Initialize in the definition";
    private static String s2;

    static {
        System.out.println(s1);
        s2 = "Initialize in static block";
    }

    public static void main(String[] args) {
        System.out.println(s1);
        System.out.println(s2);
    }
}
