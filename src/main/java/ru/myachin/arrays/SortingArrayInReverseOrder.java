package ru.myachin.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * 23. Создайте массив {@link Integer}, заполните его случайными значениями <tt>int</tt> (с использованием
 * автоматической упаковки) и отсортируйте в обратном порядке с использованием {@link java.util.Comparator}.
 */
public class SortingArrayInReverseOrder {

    public static void main(String[] args) {
        Random random = new Random(47);
        Integer[] integers = new Integer[10];
        for (int i = 0, n = integers.length; i < n; i++) {
            integers[i] = random.nextInt(n * n);
        }

        Arrays.sort(integers, Collections.reverseOrder());
        System.out.println(Arrays.toString(integers));
    }
}
