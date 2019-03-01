package ru.myachin.initialization;

/**
 * 20. Напишите метод {@link #main(String...)}, использующий список аргументов переменной длины вместо обычного
 * синтаксиса. Выведите все элементы полученного массива <b>args</b>. Протестируйте программу с разным количеством
 * аргументов командной строки.
 */
public class MainWithVarArg {

    public static void main(String... args) {
        VarArgString.printStrings(args);
    }
}