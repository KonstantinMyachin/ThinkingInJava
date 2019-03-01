package ru.myachin.arrays;

import net.mindview.util.Generated;

import java.util.Arrays;

/**
 * 18. Создайте и заполните массив оъектов {@link BerylliumSphere}. Скопируйте его в новый массив и продемонстрируйте,
 * что копирование было поверхностным.
 */
public class ArrayCopy {

    public static void main(String[] args) {
        final BerylliumSphere[] sourceArray =
                Generated.array(BerylliumSphere.class, new BerylliumSphereGenerator(), 10);
        BerylliumSphere[] targetArray = new BerylliumSphere[10];
        System.arraycopy(sourceArray, 0, targetArray, 0, sourceArray.length);

        System.out.println(Arrays.equals(sourceArray, targetArray));
    }
}
