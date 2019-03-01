package ru.myachin.arrays;

import net.mindview.util.ConvertTo;
import net.mindview.util.CountingGenerator;
import net.mindview.util.Generated;

import java.util.Arrays;

/**
 * 20. Продемонстрируйте работу {@link Arrays#deepEquals(Object[], Object[])} для многомерных массивов.
 */
public class DeepArrayEquality {

    public static void main(String[] args) {
        int[][] array = {
                {0, 1, 2, 3, 4, 5},
                {10, 20}
        };

        final int[] integers =
                ConvertTo.primitive(Generated.array(Integer.class, new CountingGenerator.Integer(), 6));
        int[][] anotherArray = new int[2][];
        anotherArray[0] = integers;
        anotherArray[1] = new int[]{10, 20};

        System.out.println(Arrays.deepEquals(array, anotherArray));
    }
}
