package ru.myachin.arrays;

import net.mindview.util.CountingGenerator;

import java.util.Arrays;

/**
 * 12. Создайте инициализированный массив <tt>double</tt> с использованием {@link CountingGenerator}.
 * Выведите результаты
 */
public class GeneratingDoubleArray {

    public static void main(String[] args) {
        CountingGenerator.Double doubleGenerator = new CountingGenerator.Double();
        double[] doubles = new double[10];
        for (int i = 0, n = doubles.length; i < n; i++) {
            doubles[i] = doubleGenerator.next();
        }

        System.out.println(Arrays.toString(doubles));
    }
}
