package ru.myachin.operators;

/**
 * 10. Напишите программу с двумя константами: обе константы состоят из чередующихся нулей  единиц, но у одной нулю
 * равен младший бит, а у другой старший (подсказка: константы проще всего определять в шестнадцатиричном виде).
 * Объедините эти две константы всем возможными празрядными операторами. Для вывода результатов используйте метод
 * <b>Integer.toBinaryString()</b>.
 */
public class BitWiseOperators {

    public static final int FIRST_INTEGER = 0x0f28fc36b;
    public static final int SECOND_INTEGER = 0xff89df90;

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(FIRST_INTEGER));
        System.out.println(Integer.toBinaryString(SECOND_INTEGER));
        System.out.println(Integer.toBinaryString(~FIRST_INTEGER));
        System.out.println(Integer.toBinaryString(~SECOND_INTEGER));
        System.out.println(Integer.toBinaryString(FIRST_INTEGER & SECOND_INTEGER));
        System.out.println(Integer.toBinaryString(FIRST_INTEGER | SECOND_INTEGER));
        System.out.println(Integer.toBinaryString(FIRST_INTEGER ^ SECOND_INTEGER));
    }
}