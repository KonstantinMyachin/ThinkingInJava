package ru.myachin.arrays;

import net.mindview.util.Generated;
import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. Измените пример <tt>ContainerComparison.java</tt>: создайте {@link Generator} для {@link BerylliumSphere} и
 * измените метод {@link #main(String[])}, чтобы он использовал {@link Generator} с {@link Generated#array(Object[], Generator)}
 */
public class BerylliumSphereContainerComparison {

    public static void main(String[] args) {
        final BerylliumSphereGenerator generator = new BerylliumSphereGenerator();
        final BerylliumSphere[] spheres = Generated.array(BerylliumSphere.class, generator, 10);
        System.out.println(Arrays.toString(spheres));

        List<BerylliumSphere> sphereList = Arrays.asList(Generated.array(BerylliumSphere.class, generator, 5));
        System.out.println(sphereList);
        System.out.println(sphereList.get(4));

        int[] integers = { 0, 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(integers));
        System.out.println(integers[4]);

        List<Integer> intList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        intList.add(97);
        System.out.println(intList);
        System.out.println(intList.get(4));
    }
}

class BerylliumSphereGenerator implements Generator<BerylliumSphere> {

    @Override
    public BerylliumSphere next() {
        return new BerylliumSphere();
    }
}