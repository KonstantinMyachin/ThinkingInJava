package ru.myachin.arrays;

import net.mindview.util.CountingGenerator;

import java.util.Arrays;

/**
 * 14. Создайте массив каждого из примитивных типов. Заполните каждый массив использованием {@link CountingGenerator}.
 * Выведите содержимое каждого массива.
 */
public class GeneratingFilledPrimitiveArrays {

    public static void main(String[] args) {
        final int size = 10;

        boolean[] booleans = new boolean[size];
        byte[] bytes = new byte[size];
        char[] chars = new char[size];
        short[] shorts = new short[size];
        int[] ints = new int[size];
        float[] floats = new float[size];
        long[] longs = new long[size];
        double[] doubles = new double[size];

        final CountingGenerator.Boolean booleanGenerator = new CountingGenerator.Boolean();
        final CountingGenerator.Byte byteGenerator = new CountingGenerator.Byte();
        final CountingGenerator.Character charGenerator = new CountingGenerator.Character();
        final CountingGenerator.Short shortGenerator = new CountingGenerator.Short();
        final CountingGenerator.Integer intGenerator = new CountingGenerator.Integer();
        final CountingGenerator.Float floatGenerator = new CountingGenerator.Float();
        final CountingGenerator.Long longGenerator = new CountingGenerator.Long();
        final CountingGenerator.Double doubleGenerator = new CountingGenerator.Double();

        for (int i = 0; i < size; i++) {
            booleans[i] = booleanGenerator.next();
            bytes[i] = byteGenerator.next();
            chars[i] = charGenerator.next();
            shorts[i] = shortGenerator.next();
            ints[i] = intGenerator.next();
            floats[i] = floatGenerator.next();
            longs[i] = longGenerator.next();
            doubles[i] = doubleGenerator.next();
        }

        System.out.println(Arrays.toString(booleans));
        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(chars));
        System.out.println(Arrays.toString(shorts));
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(floats));
        System.out.println(Arrays.toString(longs));
        System.out.println(Arrays.toString(doubles));
    }
}
