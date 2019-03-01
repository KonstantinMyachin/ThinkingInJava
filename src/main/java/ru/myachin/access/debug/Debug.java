package ru.myachin.access.debug;

/**
 * 3. Создайте два пакета <b>debug и debugoff</b>, содержащие одинаковые класс с методом <b>debug()</b>. Первая версия
 * выводит на консоль свой аргумента типа {@link String}, вторая не делает ничего. Используйте директиву
 * <b>static import</b> для импортирования класса в тестовую прогармму и продемонстрируйте эффект условной коммпиляции.
 */
public class Debug {

    public static void debug(String s) {
        System.out.println(s);
    }
}
