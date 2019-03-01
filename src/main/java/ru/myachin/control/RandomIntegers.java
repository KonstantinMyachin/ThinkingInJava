package ru.myachin.control;

import java.util.Random;

/**
 * 2. Напишите программу, которая генерирует 25 случайных значений типа <b>int</b>. Для каждого значения команда
 * <b>if-else</b> сообщает, в каком сотношении оно находится с другим случайно сгенерированным числом (больше, меньше,
 * ровно).
 */
public class RandomIntegers {

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 25; i++) {
            compare(random.nextInt(), random.nextInt());
        }
    }

    static void compare(int i1, int i2) {
        if (i1 > i2) {
            System.out.println(String.format("%d > %d", i1, i2));
        } else if (i1 < i2) {
            System.out.println(String.format("%d < %d", i1, i2));
        } else {
            System.out.println(String.format("%d = %d", i1, i2));
        }
    }
}
