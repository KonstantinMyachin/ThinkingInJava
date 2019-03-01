package ru.myachin.operators;

/**
 * 11. Начните с числа, содержащего двоичную 1 в старшем бите (подсказка: вопсользуйтесь шестнадцатеричной константой).
 * Используя знаковый оператор сдвига вправо, сдвигайте знак до крайней правой позиции, с выводом всех промежуточных
 * результатов методом {@link Integer#toBinaryString(int)}.
 */
public class SignedRightShift {

    public static void main(String[] args) {
        int i = Integer.MIN_VALUE;
        for (int j = 0; j < 32; j++) {
            System.out.println(Integer.toBinaryString(i));
            i = rightShift(i);
        }
    }

    static int rightShift(int i) {
        return i >> 1;
    }
}