package ru.myachin.arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * 4. Повторите {@link TwoDDoubleArray предыдущее упражнение} для трехмерного массива.
 */
public class ThreeDDoubleArray {

    public static void main(String[] args) {
        double[][][] array = createArray(4, 6, 5, 10, 20);
        printArray(array);
        array = createArray(2, 2, 2, 0, 1);
        printArray(array);
        array = createArray(9, 5, 1, -6, 55);
        printArray(array);
    }

    private static double[][][] createArray(int x, int y, int z, double minValue, double maxValue) {
        Random random = new Random(5);
        double[][][] result = new double[x][y][z];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result[i][j][k] = minValue + (maxValue - minValue) * random.nextDouble();
                }
            }
        }

        return result;
    }

    private static void printArray(double[][][] array) {
        System.out.println(Arrays.deepToString(array));
    }
}
