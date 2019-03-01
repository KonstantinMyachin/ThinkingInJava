package ru.myachin.control;

import ru.myachin.operators.BitWiseOperators;

/**
 * 4. Повторите {@link ru.myachin.operators.BitWiseOperators упражнение 10 из предыдущей главы}, используя тернарный
 * оператор и поразрядную проверку для вывода нулей и единиц (вместо вызова метода {@link Integer#toBinaryString(int)}.
 */
public class BitWiseOperators2 {

    public static void main(String[] args) {

        System.out.println(getBinaryString(BitWiseOperators.FIRST_INTEGER));
        System.out.println(getBinaryString(BitWiseOperators.SECOND_INTEGER));
        System.out.println(getBinaryString(~BitWiseOperators.FIRST_INTEGER));
        System.out.println(getBinaryString(~BitWiseOperators.SECOND_INTEGER));
        System.out.println(getBinaryString(BitWiseOperators.FIRST_INTEGER & BitWiseOperators.SECOND_INTEGER));
        System.out.println(getBinaryString(BitWiseOperators.FIRST_INTEGER | BitWiseOperators.SECOND_INTEGER));
        System.out.println(getBinaryString(BitWiseOperators.FIRST_INTEGER ^ BitWiseOperators.SECOND_INTEGER));
    }

    static String getBinaryString(int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = 31; j >= 0; j--) {
            char c = i << j >>> 31 == 1 ? '1' : '0';
            sb.append(c);
        }

        return sb.reverse().toString();
    }
}
