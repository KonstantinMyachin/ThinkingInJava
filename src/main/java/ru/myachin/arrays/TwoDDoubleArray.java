package ru.myachin.arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * 3. Напишите метод, который создает и инициализирует двумерный массив <tt>double</tt>. Размер массива определяется
 * аргументами метода, а значения инициализации лежат в диапазоне, определяемом начальным и конечным индексами, также
 * передаваемыми в аргументах метода. Создайте второй метод для вывода массива, сгенерированного первым методом.
 * Протестируйте методы в {@link #main(String[])} - создайте и выведите массивы нескольких разных размеров.
 */
public class TwoDDoubleArray {

    public static void main(String[] args) {
        double[][] array = createArray(4, 6, 10, 20);
        printArray(array);
        array = createArray(2, 2, 0, 1);
        printArray(array);
        array = createArray(9, 5, -6, 55);
        printArray(array);
    }

    private static double[][] createArray(int x, int y, double minValue, double maxValue) {
        Random random = new Random(5);
        double[][] result = new double[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                result[i][j] = minValue + (maxValue - minValue) * random.nextDouble();
            }
        }

        return result;
    }

    private static void printArray(double[][] array) {
        System.out.println(Arrays.deepToString(array));
    }
}
