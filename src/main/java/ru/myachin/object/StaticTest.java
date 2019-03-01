package ru.myachin.object;

/**
 * 8. Напишите прогармму, демонстрирующую, что независимо от количества созданных объектов класс содержит только один
 * экземпляр поля static.
 */
public class StaticTest {

    static int i = 47;

    public static void main(String[] args) {
        StaticTest st1 = new StaticTest();
        StaticTest st2 = new StaticTest();

        System.out.println(st1.i == st2.i);
        i++;
        System.out.println(st1.i == st2.i);
    }
}