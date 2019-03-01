package ru.myachin.arrays;

import java.util.Arrays;

/**
 * 6. Напишите метод, который получает два аргумента <tt>int</tt>, определяющие два размера двумерного массива. Метод
 * должен создавать и заполнять двумерный массив объект {@link BerylliumSphere}, соответствующий переданным аргументам.
 */
public class FillingNonPrimitiveTwoDArray {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(createArray(5, 5)));
    }

    private static BerylliumSphere[][] createArray(int x, int y) {
        BerylliumSphere[][] result = new BerylliumSphere[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                result[i][j] = new BerylliumSphere();
            }
        }

        return result;
    }
}
