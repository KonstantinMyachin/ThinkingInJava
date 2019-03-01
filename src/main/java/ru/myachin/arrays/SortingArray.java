package ru.myachin.arrays;

import net.mindview.util.Generated;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 21. Попробуйте отсортировать массив объектов из {@link ArrayCopy упражнения 18}. Реализуйте {@link Comparable} для
 * решения проблемы. Теперь создайте {@link Comparator} для сортировки объектов в обратном порядке.
 */
public class SortingArray {

    public static void main(String[] args) {
        final BerylliumSphere[] array = Generated.array(BerylliumSphere.class, new BerylliumSphereGenerator(), 10);
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        Arrays.sort(array, new ReverseOrderComparator());
        System.out.println(Arrays.toString(array));
    }
}

class ReverseOrderComparator implements Comparator<BerylliumSphere> {

    @Override
    public int compare(BerylliumSphere o1, BerylliumSphere o2) {
        return o1.compareTo(o2) * -1;
    }
}
