package ru.myachin.operators;

/**
 * 12. Начните с числа, состоящего из двоичных единиц. Сдвиньте его влево, а затем используйте беззнаковый оператор
 * оператор сдвига вправо по всем двоичным позициям с выводом всех промежуточных реузльтатов методом
 * {@link Integer#toBinaryString(int)}.
 */
public class UnsignedRightShift {

    public static void main(String[] args) {
        int i = -1 << 1;
        for (int j = 0; j < 32; j++) {
            System.out.println(Integer.toBinaryString(i));
            i = rightShift(i);
        }
    }

    static int rightShift(int i) {
        return i >>> 1;
    }
}