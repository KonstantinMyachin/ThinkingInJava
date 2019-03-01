package ru.myachin.arrays;

import java.util.Arrays;

/**
 * 7. Повторите {@link FillingNonPrimitiveTwoDArray предыдущее упражнение} для трехмерного массива.
 */
public class FillingNonPrimitiveThreeDArray {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(createArray(5, 5, 5)));
    }

    private static BerylliumSphere[][][] createArray(int x, int y, int z) {
        BerylliumSphere[][][] result = new BerylliumSphere[x][y][z];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result[i][j][k] = new BerylliumSphere();
                }
            }
        }

        return result;
    }
}
