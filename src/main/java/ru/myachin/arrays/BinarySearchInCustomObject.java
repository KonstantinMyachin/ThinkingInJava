package ru.myachin.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * 24. Покажите, что в {@link IntegerData классе из упражнения 19 возможен поиск)
 */
public class BinarySearchInCustomObject {

    public static void main(String[] args) {
        final Random random = new Random(47);
        final IntegerData searchingData = new IntegerData(5);
        IntegerData[] array = {
                new IntegerData(random.nextInt()),
                new IntegerData(random.nextInt()),
                new IntegerData(random.nextInt()),
                new IntegerData(random.nextInt()),
                new IntegerData(random.nextInt()),
                searchingData
        };

        final IntegerDataComparator comparator = new IntegerDataComparator();
        Arrays.sort(array, comparator);
        System.out.println(Arrays.toString(array));
        final int search = Arrays.binarySearch(array, searchingData, comparator);
        System.out.println(search);
    }
}

class IntegerDataComparator implements Comparator<IntegerData> {

    @Override
    public int compare(IntegerData o1, IntegerData o2) {
        return o1.compareTo(o2);
    }
}