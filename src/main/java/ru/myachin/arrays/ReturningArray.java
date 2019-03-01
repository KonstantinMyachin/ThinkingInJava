package ru.myachin.arrays;

import java.util.Arrays;

/**
 * 2. Напишите метод, который получает аргумент <tt>int</tt> и возвращает массив указанного размера, заполненный
 * объектами {@link BerylliumSphere}
 */
public class ReturningArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(returnFilledArray(3)));
    }

    private static BerylliumSphere[] returnFilledArray(int n) {
        BerylliumSphere[] result = new BerylliumSphere[n];
        for (int i = 0; i < n; i++) {
            result[i] = new BerylliumSphere();
        }

        return result;
    }
}
