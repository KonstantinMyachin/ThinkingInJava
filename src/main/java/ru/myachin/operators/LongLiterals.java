package ru.myachin.operators;

/**
 * 8. Покажите, что шестнадцатеричная и восьмеричная записи могут использоваться с типом <b>long</b>. Для вывода
 * результатов используйте метод <b>Long.toBinaryString()</b>.
 */
public class LongLiterals {

    public static void main(String[] args) {
        long l = 0xf4e4dcd3;
        printBinary(l);
        long l2 = 07776655443;
        printBinary(l2);
    }

    private static void printBinary(long l) {
        System.out.println(Long.toBinaryString(l));
    }
}