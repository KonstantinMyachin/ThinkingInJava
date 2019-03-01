package ru.myachin.arrays;

import java.util.Arrays;

/**
 * 22. Покажите, что вызов {@link Arrays#binarySearch(int[], int)} для неотсортированного массива приводи к
 * непредсказуемым реузльтатам.
 */
public class BinarySearchUnsortedArray {

    public static void main(String[] args) {
        int[] ints = {
                0, 10, 2, -2, 19, 6, 7, 5
        };

        final int i = Arrays.binarySearch(ints, 5);
        System.out.println(i);
    }
}
